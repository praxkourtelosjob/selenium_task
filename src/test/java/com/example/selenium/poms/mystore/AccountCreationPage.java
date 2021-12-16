package com.example.selenium.poms.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreationPage {
    private WebDriver driver;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastname;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "phone_mobile")
    private WebElement phone;

    @FindBy(id = "submitAccount")
    private WebElement register;

    public AccountCreationPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void fillOutForm() {
        customerFirstName.sendKeys("test");
        customerLastname.sendKeys("test");
        passwd.sendKeys("random");
        address1.sendKeys("random");
        city.sendKeys("random");
        Select stateSelect = new Select(state);
        stateSelect.selectByVisibleText("Alabama");
        postcode.sendKeys("00000");
        phone.sendKeys("00000000000");
    }

    public MyAccountPage goToMyAccountPage() {
        register.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("info-account")));
        return PageFactory.initElements(driver, MyAccountPage.class);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(WebElement customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public WebElement getCustomerLastname() {
        return customerLastname;
    }

    public void setCustomerLastname(WebElement customerLastname) {
        this.customerLastname = customerLastname;
    }

    public WebElement getPasswd() {
        return passwd;
    }

    public void setPasswd(WebElement passwd) {
        this.passwd = passwd;
    }

    public WebElement getAddress1() {
        return address1;
    }

    public void setAddress1(WebElement address1) {
        this.address1 = address1;
    }

    public WebElement getCity() {
        return city;
    }

    public void setCity(WebElement city) {
        this.city = city;
    }

    public WebElement getState() {
        return state;
    }

    public void setState(WebElement state) {
        this.state = state;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public void setPostcode(WebElement postcode) {
        this.postcode = postcode;
    }

    public WebElement getPhone() {
        return phone;
    }

    public void setPhone(WebElement phone) {
        this.phone = phone;
    }

    public WebElement getRegister() {
        return register;
    }

    public void setRegister(WebElement register) {
        this.register = register;
    }
}
