package com.example.selenium.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        Actions login = new Actions(this.driver)
                .sendKeys(userNameField, uname)
                .sendKeys(passwordField, password).click(loginButton);
        login.perform();
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

    public void sendUsername(String uname) {
        userNameField.sendKeys(uname);
    }

    public void sendPasssword(String pass) {
        passwordField.sendKeys(pass);
    }

    public void clickLogin() {
        this.loginButton.click();
    }
}
