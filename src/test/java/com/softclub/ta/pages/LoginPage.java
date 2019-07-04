package com.softclub.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='view_container']//form[@method='post']//input[@type='email']")
    private WebElement emailField;

    @FindBy(id = "identifierNext")
    private WebElement nextButton;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='passwordNext']//span[@class='RveJvd snByac']")
    private WebElement passwordNextButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getPasswordField() {
        waitForVisibilityOf(passwordField);
        return passwordField;
    }

    public MainPage fillLogInForm(String email, String password) {
        fillEmailField(email);
        fillPassword(password);
        return PageFactory.initElements(getDriver(), MainPage.class);
    }

    private void fillEmailField(String email) {
        waitForVisibilityOf(emailField);
        emailField.sendKeys(email);
        clickButton(nextButton);
    }

    private void fillPassword(String password) {
        waitForVisibilityOf(passwordField);
        passwordField.sendKeys(password);
        clickButton(passwordNextButton);
    }
}
