package com.akqa.bp.navitas.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.testng.AssertJUnit.assertEquals;
@Deprecated
public class BasePageOld {

//    protected static final Logger LOGGER = LogManager.getLogger(BasePageOld.class);
//    protected static final String URL_MY_SERVICE_APP = EnvironmentConfigurator.getInstance().getMyServiceUrl();
//    protected static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BasePageOld.class);
//    private static final int HEADER_HEIGHT = -47;
//    @FindBy(css = ".msv-header")
//    protected WebElement headerCommon;
//
//    @FindBy(css = ".sbe-logo")
//    protected WebElement sbeLogo;
//
//    protected By loaderSpinner = By.cssSelector(".loading-spinner:not(.ng-hide)");
//
//    private RemoteWebDriver webDriver;
//    private Wait<WebDriver> visibilityWait;
//    private Wait<WebDriver> invisibilityWait;
//    private WebDriverWait webDriverWait;
//
//    public BasePageOld(RemoteWebDriver webDriver) {
//        this.webDriver = webDriver;
//
//        webDriverWait = new WebDriverWait(webDriver, Client.TIME_WAIT_SECONDS);
//        PageFactory.initElements(webDriver, this);
//        waitForInvisibility(loaderSpinner);
//    }
//
//    protected RemoteWebDriver getWebDriver() {
//        return webDriver;
//    }
//
//    public void sendKeys(final WebElement webElement, String text) {
//        waitForClickable(webElement);
//        if (EnvironmentConfigurator.getInstance().getTestClient().equals(ClientType.IE.toString())) {
//            webElement.sendKeys("a");
//        }
//        webElement.clear();
//        webElement.sendKeys(text);
//    }
//
//    public void pressEnter(final WebElement webElement) {
//        waitForClickable(webElement);
//        webElement.sendKeys(Keys.ENTER);
//    }
//
//    protected WebElement waitForVisibility(WebElement webElement) {
//        try {
//            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
//        } catch (NoSuchElementException nse) {
//            LOGGER.error("", nse);
//            return null;
//        }
//        return webElement;
//    }
//
//    protected WebElement waitForVisibility(By locator) {
//        try {
//            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        } catch (NoSuchElementException nse) {
//            LOGGER.error("", nse);
//            return null;
//        }
//        return getWebDriver().findElement(locator);
//    }
//
//    protected void waitForInvisibility(final By locator) {
//        try {
//            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//        } catch (NoSuchElementException e) {
//            LOGGER.error("", e);
//        }
//    }
//
//    protected WebElement waitForClickable(WebElement webElement) {
////        waitForVisibility(webElement);
//        try {
//            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
//        } catch (NoSuchElementException nse) {
//            LOGGER.error("Try to wait little more (wait for clickable)", nse);
//        }
//        return webElement;
//    }
//
//    protected boolean click(WebElement webElement) {
//        boolean result = false;
//        int attempts = 0;
//        while (attempts < 3) {
//            try {
//                scrollToElement(waitForVisibility(webElement));
//                waitForClickable(webElement).click();
//                result = true;
//                break;
//            } catch (StaleElementReferenceException ignored) {
//                LOGGER.error("", ignored);
//            }
//            attempts++;
//        }
//        return result;
//    }
//
//    protected String getImageNameFromAbsolutePath(File fileToParse) {
//        int indexOfSlash;
//        if (fileToParse.getAbsolutePath().contains("/"))
//            indexOfSlash = fileToParse.getAbsolutePath().lastIndexOf('/');
//        else indexOfSlash = fileToParse.getAbsolutePath().lastIndexOf('\\');
//        int indexOfDot = fileToParse.getAbsolutePath().lastIndexOf('.');
//        return fileToParse.getAbsolutePath().substring(indexOfSlash + 1, indexOfDot);
//    }
//
//    protected String getImageNameFromStringPath(String path) {
//        int indexOfSlash;
//        if (path.contains("/"))
//            indexOfSlash = path.lastIndexOf('/');
//        else indexOfSlash = path.lastIndexOf('\\');
//        int indexOfDot = path.lastIndexOf('.');
//        return path.substring(indexOfSlash + 1, indexOfDot);
//    }
//
//    protected boolean isElementPresent(final WebElement we) {
//        webDriver.getPageSource();
//        try {
//            return we.isDisplayed();
//        } catch (Exception e) {
////            LOGGER.error("", e);
//            return false;
//        }
//    }
//
//    protected void selectCustomDropDown(WebElement buttonSelect, List<WebElement> optionsLinks, String textToSelect) {
//        click(buttonSelect);
//        for (WebElement optionLink : optionsLinks) {
//            if (waitForClickable(optionLink).getText().equalsIgnoreCase(textToSelect)) {
//                optionLink.click();
//                break;
//            }
//        }
//    }
//
//    public RemoteWebDriver switchToNewlyOpenedTab() {
//        RemoteWebDriver webDriverNewTab;
//        List<String> currentTabs = new ArrayList<>(getWebDriver().getWindowHandles());
//        webDriverNewTab = (RemoteWebDriver) getWebDriver().switchTo().window(currentTabs.get(getWebDriver().getWindowHandles().size() - 1));
//        webDriverNewTab.manage().window().maximize();
//        return webDriverNewTab;
//    }
//
//    protected void moveMouseCursorToWebElement(WebElement webElement) {
//        waitForClickable(webElement);
//        scrollToElement(webElement);
//        Actions action = new Actions(getWebDriver());
//        action.moveToElement(webElement).perform();
//    }
//
//    protected void clickAndHoldWebElement(WebElement webElement) {
//        waitForClickable(webElement);
//        scrollToElement(webElement);
//        Actions action = new Actions(getWebDriver());
//        action.clickAndHold(webElement).perform();
//    }
//
//    protected void doubleClickElement(WebElement webElement) {
//        scrollToElement(webElement);
//        waitForClickable(webElement);
//        Actions action = new Actions(getWebDriver());
//        action.doubleClick(webElement).perform();
//    }
//
//    protected Object executeJS(final String script, final Object... params) {
//        return getWebDriver().executeScript(script, params);
//    }
//
//    protected WebElement scrollToElement(WebElement we) {
//        /* this serves to avoid 2 problems:
//            1. frozen navigation bar on top of processDefinitionEditorPage that overlay elements in case of scroll up
//            2. error notifier that accidentally appears and overlay element also
//        */
//        executeJS("arguments[0].scrollIntoView(true);", we);
//        executeJS(String.format("javascript:window.scrollBy(%d,%d)", 0, HEADER_HEIGHT));
//        return we;
//    }
//
//    protected String getValueFromElement(WebElement webElement) {
//        return executeJS("return arguments[0].value", webElement).toString();
//    }
//
//    @Step
//    protected void verifyFieldErrorNotifier(WebElement errorNotifierContainer, WebElement errorNotifierFlyOut, String reason) {
//        waitForClickable(errorNotifierContainer);
//        scrollToElement(errorNotifierContainer);
//        moveMouseCursorToWebElement(errorNotifierContainer);
//        waitForVisibility(errorNotifierFlyOut);
//        assertEquals("Hint Text isn't expected", reason, errorNotifierFlyOut.getText());
//    }
//
//    @Step
//    public void refreshPage() {
//        getWebDriver().navigate().refresh();
//        waitForVisibility(sbeLogo);
//        waitForInvisibility(loaderSpinner);
//    }

}