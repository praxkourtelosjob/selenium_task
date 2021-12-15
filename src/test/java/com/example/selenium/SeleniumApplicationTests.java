package com.example.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumApplicationTests {

	WebDriver webDriver;

	@Before
	public void setup() {
		webDriver = new ChromeDriver();
		WebDriver.Options options = webDriver.manage();
	}

	@After
	public void teardown() {
		// When we use a WebDriver, the resource must be closed when we are done
		webDriver.quit();
	}

	@Test
	public void One() throws InterruptedException {
		login(webDriver, "standard_user", "secret_sauce");

		WebElement title = webDriver.findElement(new By.ByClassName("title"));
		System.out.println(title.getText());
		assert(title.getText().equals("PRODUCTS"));
	}

	@Test
	public void Two() throws InterruptedException {
		login(webDriver, "locked_out_user", "secret_sauce");

		WebElement error = webDriver.findElement(new By.ByClassName("error-message-container"));
		System.out.println(error.getText());
		assert(error.getText().equals("Epic sadface: Sorry, this user has been locked out."));
	}

	@Test
	public void Three() throws InterruptedException {
		login(webDriver, "problem_user", "wrong");

		WebElement error = webDriver.findElement(new By.ByClassName("error-message-container"));
		System.out.println(error.getText());
		assert(error.getText().equals("Epic sadface: Username and password do not match any user in this service"));
	}

	private void login(WebDriver webDriver, String logins, String passw) throws InterruptedException {
		webDriver.get("https://www.saucedemo.com/");
		WebElement uname = webDriver.findElement(new By.ById("user-name"));
		uname.sendKeys(logins);
		WebElement pass = webDriver.findElement(new By.ById("password"));
		pass.sendKeys(passw);
		WebElement login = webDriver.findElement(new By.ById("login-button"));
		login.click();
		Thread.sleep(100L);
	}


}
