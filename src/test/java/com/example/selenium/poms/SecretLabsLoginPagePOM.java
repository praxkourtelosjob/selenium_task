package com.example.selenium.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecretLabsLoginPagePOM {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(className = "error-message-container")
    private WebElement errorMessageContainer;

    public SecretLabsLoginPagePOM(WebDriver webDriver) {
        this.driver = webDriver;
        navigate();
        PageFactory.initElements(webDriver, this);
    }

    public void login(String uname, String password) {
        userNameField.sendKeys(uname);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void navigate() {
        this.driver.get("https://www.saucedemo.com/");
    }

    public WebElement getUserNameField() {
        return userNameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getErrorMessageContainer() {
        PageFactory.initElements(driver, this);
        return errorMessageContainer;
    }
}
