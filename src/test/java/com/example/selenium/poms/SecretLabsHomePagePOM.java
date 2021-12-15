package com.example.selenium.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SecretLabsHomePagePOM {

    private WebDriver driver;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "title")
    private WebElement title;

    public SecretLabsHomePagePOM(WebDriver webDriver, String uname, String pass) {
        this.driver = webDriver;
        SecretLabsLoginPagePOM secretLabsLoginPagePOM = new SecretLabsLoginPagePOM(this.driver);
        secretLabsLoginPagePOM.login(uname, pass);
        PageFactory.initElements(webDriver, this);

        for (WebElement item:inventoryItems) {
            System.out.println(item.getText());
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<WebElement> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public WebElement getTitle() {
        return title;
    }

    public void setTitle(WebElement title) {
        this.title = title;
    }
}
