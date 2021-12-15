package com.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
	
	public static WebDriver getDriver() throws Exception {
        // get the value of a property called "browser", or default to "edge" if unavailable
        String webDriver = System.getProperty("browser", "edge");

        switch (webDriver.toUpperCase()) {
            case "CHROME":
            	ChromeOptions co = new ChromeOptions();
                return new ChromeDriver(co);
            case "FIREFOX":
            	FirefoxOptions fo = new FirefoxOptions();
                return new FirefoxDriver(fo);
            case "EDGE":
            	EdgeOptions eo = new EdgeOptions();
            	return new EdgeDriver(eo);
            default:
                throw new Exception("[Fatal] No driver available: No browser property supplied and could not default to ChromeDriver");
        }
    }

	public static WebDriver getDriver(String webDriver) throws Exception {
		if (webDriver.isBlank()) webDriver = "edge";
        switch (webDriver.toUpperCase()) {
            case "CHROME":
            	ChromeOptions co = new ChromeOptions();
                return new ChromeDriver(co);
            case "FIREFOX":
            	FirefoxOptions fo = new FirefoxOptions();
                return new FirefoxDriver(fo);
            case "EDGE":
            	EdgeOptions eo = new EdgeOptions();
            	return new EdgeDriver(eo);
            default:
                throw new Exception("[Fatal] No driver available: No browser property supplied and could not default to ChromeDriver");
        }
    }
}
