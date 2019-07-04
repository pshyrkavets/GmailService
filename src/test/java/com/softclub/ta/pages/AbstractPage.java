package com.softclub.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private WebDriver driver;
    public static final int WEB_DRIVER_WAIT_IN_SECONDS = 10;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void waitForVisibilityOf(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, WEB_DRIVER_WAIT_IN_SECONDS);
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(element);
        webDriverWait.until(condition);
    }

    public void clickButton(WebElement button) {
        waitForVisibilityOf(button);
        button.click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
