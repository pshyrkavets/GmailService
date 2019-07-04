package com.softclub.ta.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import com.softclub.ta.driver.DriverSingleton;
import com.softclub.ta.pages.LoginPage;
import com.softclub.ta.pages.MainPage;

public class TestScenario1 {
    private static final String LOGIN_PAGE = "https://www.gmail.com";
    private static final String IS_NOT_DISPLAYED_MESSAGE = " is not displayed";
    private static final String EMAIL = "pavelsoft2019@gmail.com";
    private static final String PASSWORD = "asdZXC2019";

    @Test
    public void fillLoginForm() {
        LoginPage loginPage = PageFactory.initElements(DriverSingleton.getDriver(), LoginPage.class);
        loginPage.openPage(LOGIN_PAGE);
        MainPage mainPage = loginPage.fillLogInForm(EMAIL, PASSWORD);
        Assert.assertTrue(mainPage.getWriteANewLetterButton().isDisplayed(), "Refresh button"
                + IS_NOT_DISPLAYED_MESSAGE);
    }

    @AfterTest
    public void dismissDriver() {
        DriverSingleton.closeDriver();
    }
}