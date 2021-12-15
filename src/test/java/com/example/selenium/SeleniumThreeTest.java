package com.example.selenium;

import com.example.selenium.poms.SecretLabsHomePagePOM;
import com.example.selenium.poms.SecretLabsLoginPagePOM;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumThreeTest {
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
    public void one() {
        SecretLabsHomePagePOM secretLabdsHomePagePOM = new SecretLabsHomePagePOM(webDriver, "standard_user", "secret_sauce");
        assert(secretLabdsHomePagePOM.getTitle().getText().equals("PRODUCTS"));
    }

    @Test
    public void two() {
        SecretLabsLoginPagePOM secretLabsLoginPagePOM = new SecretLabsLoginPagePOM(webDriver);
        secretLabsLoginPagePOM.login("locked_out_user", "secret_sauce");
        assert(secretLabsLoginPagePOM.getErrorMessageContainer().getText().equals("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    public void three() {
        SecretLabsLoginPagePOM secretLabsLoginPagePOM = new SecretLabsLoginPagePOM(webDriver);
        secretLabsLoginPagePOM.login("problem_user", "wrong");
        assert(secretLabsLoginPagePOM.getErrorMessageContainer().getText().equals("Epic sadface: Username and password do not match any user in this service"));
    }
}
