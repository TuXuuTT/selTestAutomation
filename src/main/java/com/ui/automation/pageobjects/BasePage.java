package com.ui.automation.pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.ui.automation.browserClient.BrowserClient;
import com.ui.automation.environment.EnvironmentConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public abstract class BasePage {
    protected final Logger LOGGER = LogManager.getLogger(this);
    private final WebDriver wd;

    public BasePage() {
        wd = WebDriverRunner.getWebDriver();
    }

    public static String getPageURL() {
        return EnvironmentConfigurator.getInstance().getAppUrl();
    }

    protected WebDriver getWebDriverCurrent() {
        return wd;
    }

    protected void openUrl(String url) {
        Selenide.open(url);
        LOGGER.info("Loading page: {}", url);
    }

    public void setWebDriverWindowSize(int width, int height) {
        wd.manage().window().setPosition(new Point(0, 0));
        wd.manage().window().setSize(new Dimension(width, height));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Dimension getWebDriverWindowsSize() {
        return wd.manage().window().getSize();
    }

    protected Object executeJS(final String script, final Object... params) {
        return ((JavascriptExecutor) wd).executeScript(script, params);
    }

    public int getPageBodyWidth() {
        return Integer.parseInt(executeJS("return document.body.clientWidth").toString());
    }

    public void maximizeWebdriverWindow() {
        BrowserClient.maximizeWindow(wd);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void waitForElementStopMoving(WebElement element) {
        Point a;
        Point b;
        do {
            a = element.getLocation();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b = element.getLocation();
        } while (!a.equals(b));
    }

    public void dragAndDropMadCap(WebElement dragElement, WebElement dropElement, /*String iFrameName,*/ int msDelayBeforeDrop, int x, int y) {
        // Init our action builder;
        Actions builder = new Actions(getWebDriverCurrent());

        // Pickup the dragElement
        builder.clickAndHold(dragElement).perform();

        // If delay required, delay
        if (msDelayBeforeDrop > 0)
            Selenide.sleep(msDelayBeforeDrop);

        // If across frames, switch frame
//            if (iFrameName != null && !iFrameName.isEmpty())
//                switchToFrame(iFrameName);

        // Move to the dropElement
        if (x != -1 || y != -1) {
            // If we are dropping "Above" the target, drag to the element, then move to above
            if (y < 0) {
                // Make sure there is space above the element
                ((JavascriptExecutor) getWebDriverCurrent()).executeScript("arguments[0].scrollIntoView(); document.body.scrollTop += " + (y - 5), dropElement);
                builder.moveToElement(dropElement).perform();
                Selenide.sleep(msDelayBeforeDrop);
            }
            builder.moveToElement(dropElement, x, y).perform();
        } else {
            builder.moveToElement(dropElement).perform();
        }

        // If delay required, delay
//        if (msDelayBeforeDrop > 0)
//            Selenide.sleep(msDelayBeforeDrop);
        waitForElementStopMoving(dragElement);

        // Release the drag element
        builder.release().perform();
    }
}
