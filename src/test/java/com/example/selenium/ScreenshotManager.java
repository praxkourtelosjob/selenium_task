package com.example.selenium;

import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenshotManager {
    private File currentScreenshot;

    public void takeScreenshot(WebDriver driver) {
        currentScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    public void takeElementScreenshot(WebDriver webDriver, By by) {
        WebElement webElement = webDriver.findElement(by);
        currentScreenshot = webElement.getScreenshotAs(OutputType.FILE);
    }

    public void saveScreenshot(String path) throws IOException {
        currentScreenshot.renameTo(new File(path));
        currentScreenshot.createNewFile();
    }

    public void takeAndSaveScreenshot(WebDriver webDriver, String path) throws IOException {
        takeScreenshot(webDriver);
        saveScreenshot(path);
    }

    public void takeAndSaveElementScreenshot(WebDriver webDriver, By by, String path) throws IOException {
        takeElementScreenshot(webDriver, by);
        saveScreenshot(path);
    }
}
