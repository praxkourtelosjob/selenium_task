package com.example.selenium;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverHooks {
    private WebDriver webDriver;
    // @Before and @After here are NOT the default JUnit annotations, they are
    // custom ones defined by Cucumber-JUnit for the purpose of hooks
    @Before("@selenium") // from io.cucumber.java
    public void setup() throws Exception {
        webDriver = WebDriverFactory.getDriver("chrome");
    }
    @After("@selenium") // only run for features and scenarios tagged with @selenium
    public void teardown() {
        webDriver.quit();
    }
    public WebDriver getWebDriver() {
        return this.webDriver;
    }
}
