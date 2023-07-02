package org.aggrey.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementPage {
    WebDriver driver;
    WebElement element = null;
    By addElement = By.cssSelector("button[onclick='addElement()']");
    By deleteElement = By.cssSelector("button[onclick='deleteElement()']");
    public AddRemoveElementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement addElementButton(WebDriver driver) {
        element = driver.findElement((By) addElement);
        return element;
    }

    public WebElement deleteElementButton(WebDriver driver) {
        element = driver.findElement((By) deleteElement);
        return element;
    }

    public void clickOnAddElementButton(WebDriver driver) {
        addElementButton(driver).click();
    }

    public void clickOnDeleteElementButton(WebDriver driver) {
        deleteElementButton(driver).click();
    }
}
