package com.akqa.bp.navitas.automation.web;

import com.akqa.bp.navitas.automation.BaseTest;
import com.akqa.bp.navitas.automation.pageobjects.SimpleGoogleTestPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.open;

public class TestClassToTest extends BaseTest {

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
