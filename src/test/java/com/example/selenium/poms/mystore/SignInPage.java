package com.example.selenium.poms.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class SignInPage {
    private WebDriver driver;

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement emailSubmitButton;


    public SignInPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void fillEmail() {
        this.getEmailInput().sendKeys("test" + new Random().nextInt()+"prax@test.com");
    }

    public AccountCreationPage goToAccountcreationPage() {
        emailSubmitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account_creation")));
        return PageFactory.initElements(driver, AccountCreationPage.class);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(WebElement emailInput) {
        this.emailInput = emailInput;
    }

    public WebElement getEmailSubmitButton() {
        return emailSubmitButton;
    }

    public void setEmailSubmitButton(WebElement emailSubmitButton) {
        this.emailSubmitButton = emailSubmitButton;
    }
}
