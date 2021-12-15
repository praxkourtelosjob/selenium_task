package com.example.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class SeleniumTwoTest {

    WebDriver webDriver;
    ScreenshotManager screenshotManager;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        WebDriver.Options options = webDriver.manage();
        screenshotManager = new ScreenshotManager();
    }

    @After
    public void teardown() {
        // When we use a WebDriver, the resource must be closed when we are done
        webDriver.quit();
    }

    @Test
    public void one() throws IOException {
        webDriver.get("https://www.bbc.co.uk/");
        String title = webDriver.getTitle();
        assert(title.equals("BBC - Home"));
        System.out.println(title);
        screenshotManager.takeAndSaveScreenshot(webDriver, "C:\\Users\\kgblo\\OneDrive\\Desktop\\selenium\\sh1.png");
    }

    @Test
    public void Two() throws IOException {
        webDriver.get("https://www.bing.com/");
        screenshotManager.takeAndSaveScreenshot(webDriver, "C:\\Users\\kgblo\\OneDrive\\Desktop\\selenium\\t1.png");

        WebElement sbar = webDriver.findElement(new By.ByName("q"));
        sbar.sendKeys("Wabba Labba Dub Dub");
        screenshotManager.takeAndSaveScreenshot(webDriver, "C:\\Users\\kgblo\\OneDrive\\Desktop\\selenium\\t2.png");
    }




}
