package com.example.selenium.poms.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@title=\"Dresses\"]")
    private WebElement dressesTab;

    @FindBy(id = "block_top_menu")
    private WebElement menu;

    @FindBy(className = "login")
    private WebElement login;

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigate() {
        driver.get("http://automationpractice.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("block_top_menu")));
    }

    public DressesPage gotToDresses() {
        dressesTab.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content_scene_cat_bg")));
        return PageFactory.initElements(driver, DressesPage.class);
    }

    public SignInPage goToSignInPage() {
        this.getLogin().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitCreate")));
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDressesTab() {
        return dressesTab;
    }

    public void setDressesTab(WebElement dressesTab) {
        this.dressesTab = dressesTab;
    }

    public WebElement getMenu() {
        return menu;
    }

    public void setMenu(WebElement menu) {
        this.menu = menu;
    }

    public WebElement getLogin() {
        return login;
    }

    public void setLogin(WebElement login) {
        this.login = login;
    }
}
