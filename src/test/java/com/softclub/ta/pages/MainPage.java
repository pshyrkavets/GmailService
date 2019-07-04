package com.softclub.ta.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    @FindBy(xpath = "//span[@class='gb_xa gbii']")
    private WebElement googleAccountButton;

    @FindBy(xpath = "//*[@id='gb_71']")
    private WebElement quitAccountButton;

    @FindBy(xpath = "//div[@gh='cm']")
    private WebElement writeANewLetterButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement forWhomField;

    @FindBy(xpath = "//input[@placeholder='Тема']")
    private WebElement topicField;

    @FindBy(xpath = "//*[@class='Am Al editable LW-avf']")
    private WebElement textBox;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@id=':2o']")
    private WebElement tableOfIncomeLetters;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage quitAccount() {
        waitForVisibilityOf(googleAccountButton);
        clickButton(googleAccountButton);
        waitForVisibilityOf(quitAccountButton);
        clickButton(quitAccountButton);
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }

    public WebElement getWriteANewLetterButton() {
        waitForVisibilityOf(writeANewLetterButton);
        return writeANewLetterButton;
    }

    public void writeANewLetter(String forWhom, String topic, String text) {
        waitForVisibilityOf(writeANewLetterButton);
        writeANewLetterButton.click();
        waitForVisibilityOf(forWhomField);
        forWhomField.sendKeys(forWhom);
        waitForVisibilityOf(topicField);
        topicField.sendKeys(topic);
        waitForVisibilityOf(textBox);
        textBox.sendKeys(text);
        waitForVisibilityOf(sendButton);
        sendButton.click();
    }

    public boolean findLetterByTopic(String topic) {
        List<WebElement> incomeLetters = tableOfIncomeLetters.findElements(By.className("bqe"));

        for(WebElement incomeLetter : incomeLetters) {
            if (incomeLetter.getText().contains(topic)) {
                return true;
            }
        }

        return false;
    }
}
