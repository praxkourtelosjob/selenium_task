package com.example.selenium.stepdefs;

import com.example.selenium.WebDriverHooks;
import com.example.selenium.poms.mystore.HomePage;
import com.example.selenium.poms.mystore.PageRepository;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MyStoreStepDef {

    private WebDriver webDriver;

    private PageRepository pages;

    public MyStoreStepDef(WebDriverHooks hooks) {
        this.webDriver = hooks.getWebDriver();
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        this.pages = new PageRepository();
        this.pages.homePage = PageFactory.initElements(this.webDriver, HomePage.class);
    }

    @Given("a user enter {word}")
    public void enterPage() {
        assert this.pages.homePage.getMenu() != null;
    }

    @And("clicks on the Sign In tag")
    public void clickSignInTag() {
        this.pages.signInPage = this.pages.homePage.goToSignInPage();
        assert this.pages.signInPage.getEmailInput() != null;
    }

    @And("fills the Email address field")
    public void fillEmail() {
        this.pages.signInPage.fillEmail();
        assert !this.pages.signInPage.getEmailInput().getText().equals("");
    }

    @And("clicks on the Create an account button")
    public void clickCreateAccount() {
        this.pages.accountCreationPage = this.pages.signInPage.goToAccountcreationPage();
        assert this.pages.accountCreationPage.getAddress1() != null;
    }

    @And("fills the account creation form")
    public void fillAccountCreationForm() {
        this.pages.accountCreationPage.fillOutForm();
        assert !this.pages.accountCreationPage.getAddress1().getText().equals("");
    }

    @And("clicks register")
    public void clickRegister() {
        this.pages.myAccountPage = this.pages.accountCreationPage.goToMyAccountPage();
        assert this.pages.myAccountPage.getAccountInfo() != null;
    }

    @Then("an account will be created")
    public void accountCreated() {
        assert !this.pages.myAccountPage.getAccountInfo().getText().isBlank();
    }
}
