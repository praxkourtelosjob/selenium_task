package com.example.selenium.stepdefs;

import com.example.selenium.WebDriverFactory;
import com.example.selenium.WebDriverHooks;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingStepDefinitions {
    private WebDriver webDriver;

    public BingStepDefinitions(WebDriverHooks webDriverHooks) {
        this.webDriver = webDriverHooks.getWebDriver();
    }

    @After
    public void teardown() {
        // When we use a WebDriver, the resource must be closed when we are done
        webDriver.quit();
    }

    @When("the user requests {word}")
    public void theUserRequestBing(String site) {
        System.out.println(site);
        webDriver.get(site);
        assert true;
    }

    @Then("the user should be on the Bing home page")
    public void theUserShouldBeOnTheBingHomePage() {
        System.out.println(webDriver.getTitle());
        assert webDriver.getTitle().equals("Bing");
    }
}
