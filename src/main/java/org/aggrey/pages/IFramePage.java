package org.aggrey.pages;

import org.aggrey.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IFramePage extends TestBase {
    private static WebElement element;

    By iframeTxt = By.cssSelector("#mce_0_ifr");
    public IFramePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement iframeTxt(WebDriver driver){
        element = driver.findElement(iframeTxt);
        return element;
    }

    public void switchToIframe(){
        driver.switchTo().frame(iframeTxt(driver));
    }
}
