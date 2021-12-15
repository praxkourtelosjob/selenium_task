package com.example.selenium;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/"},
        tags = "@selenium",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"html:target/cucumber-reports/cucumber-selenium-report.html"},
        monochrome = true)
public class CucumberSeleniumTestRunner {
}
