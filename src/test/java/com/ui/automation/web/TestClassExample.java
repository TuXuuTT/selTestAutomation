package com.ui.automation.web;

import com.ui.automation.BaseTest;
import com.ui.automation.pageobjects.SimpleGoogleTestPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.open;

public class TestClassExample extends BaseTest {

    SimpleGoogleTestPage simpleGoogleTestPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        simpleGoogleTestPage = open(SimpleGoogleTestPage.getPageURL(), SimpleGoogleTestPage.class);
    }

    @Features("Search functionality")
    @Stories({"Google search"})
    @Test(groups = {"smoke"}, description = "TC-01")
    public void testSearch() {
        simpleGoogleTestPage
                .searchFor("Random")
                .verifyPageTitle();
    }
}