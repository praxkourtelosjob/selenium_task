package com.example.selenium.stepdefs;

import com.example.selenium.WebDriverFactory;
import com.example.selenium.WebDriverHooks;
import com.example.selenium.poms.SecretLabsLoginPagePOM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwagLabsStepDef {
    private WebDriver webDriver;
    private SecretLabsLoginPagePOM secretLabsLoginPagePOM;

    public SwagLabsStepDef(WebDriverHooks webDriverHooks) {
        this.webDriver = webDriverHooks.getWebDriver();
    }

    @Before
    public void setup() {

    }

    @After
    public void teardown() {
        // When we use a WebDriver, the resource must be closed when we are done
        webDriver.quit();
    }

    @When("a user enters {word}")
    public void userEntersSite(String site) {
        secretLabsLoginPagePOM = new SecretLabsLoginPagePOM(webDriver);
        assert webDriver.getTitle().equals("Swag Labs");
    }

    @And("inputs a {word} in the username field")
    public void inputRegisteredUsername(String uname) {
        secretLabsLoginPagePOM.sendUsername(uname);
        assert secretLabsLoginPagePOM.getUserNameField().getText().equals(uname);
    }

    @And("inputs a correct password {word}")
    public void inputCorrectPassword(String pass) {
        secretLabsLoginPagePOM.sendPasssword(pass);
        assert secretLabsLoginPagePOM.getPasswordField().getText().equals(pass);
    }

    @And("clicks the login button")
    public void clickLoginButton() {
        secretLabsLoginPagePOM.clickLogin();
    }

    @Then("he should be redirected to the homepage")
    public void redirectToHomePage() {
        WebElement title = webDriver.findElement(new By.ByClassName("title"));
        assert(title.getText().equals("PRODUCTS"));
    }

    @Then("he should be receiving a locked out error")
    public void lockedOutMessage() {
        assert secretLabsLoginPagePOM.getErrorMessageContainer().getText().equals("Epic sadface: Sorry, this user has been locked out.");
    }

    @Then("he should be receiving a user does not exist error")
    public void userDoesNotExistMessage() {
        assert secretLabsLoginPagePOM.getErrorMessageContainer().getText().equals("Epic sadface: Username and password do not match any user in this service");
    }
}
