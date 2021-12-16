package com.example.selenium.poms.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;

    @FindBy(className = "info-account")
    private WebElement accountInfo;

    public MyAccountPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(WebElement accountInfo) {
        this.accountInfo = accountInfo;
    }
}
