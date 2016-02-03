package com.ui.automation.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertTrue;

public class SimpleGoogleTestPage extends BasePage {

    private static final String pageTitle = "Google";

    @FindBy(css = "#lst-ib")
    private SelenideElement inputSearch;


    @Step
    public SimpleGoogleTestPage searchFor(String textToSeach) {
        inputSearch.setValue(textToSeach).pressEnter();
        return page(this);
    }

    @Step
    public SimpleGoogleTestPage verifyPageTitle() {
        assertTrue(title().contains(pageTitle), String.format("Not on the search page, but on %s", getWebDriverCurrent().getCurrentUrl()));
        return page(this);
    }
}
