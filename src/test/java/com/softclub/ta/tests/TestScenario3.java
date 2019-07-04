package com.softclub.ta.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.softclub.ta.driver.DriverSingleton;
import com.softclub.ta.pages.LoginPage;
import com.softclub.ta.pages.MainPage;

public class TestScenario3 {
    private static final String LOGIN_PAGE = "https://www.gmail.com";
    private static final String IS_NOT_DISPLAYED_MESSAGE = " is not displayed";
    private static final String EMAIL = "pavelsoft2019@gmail.com";
    private static final String PASSWORD = "asdZXC2019";
    private static final String TOPIC = "TOPIC";
    private static final String TEXT = "TEXT";
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeTest
    public void setPreconditions() {
        loginPage = PageFactory.initElements(DriverSingleton.getDriver(), LoginPage.class);
        loginPage.openPage(LOGIN_PAGE);
        mainPage = loginPage.fillLogInForm(EMAIL, PASSWORD);
    }

    @Test
    public void writeAMessageToMyEmail() {
        mainPage.writeANewLetter(EMAIL, TOPIC, TEXT);
        Assert.assertTrue(mainPage.findLetterByTopic(TOPIC), "The message with the given topic"
                + IS_NOT_DISPLAYED_MESSAGE);
    }

    @AfterTest
    public void quitPostService() {
        loginPage = mainPage.quitAccount();
        DriverSingleton.closeDriver();
    }
}
