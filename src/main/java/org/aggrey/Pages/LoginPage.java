package org.aggrey.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    private static WebElement element;
    By userNameTextBox = By.cssSelector("#username");
    By passwordTextBox = By.cssSelector("#password");
    By loginBtn = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement userNameTxt(WebDriver driver) {
        element = driver.findElement((By) userNameTextBox);
        return element;
    }

    public WebElement passwordTxt(WebDriver driver) {
        element = driver.findElement((By) passwordTextBox);
        return element;
    }

    public WebElement loginButton(WebDriver driver) {
        element = driver.findElement((By) loginBtn);
        return element;
    }

    public void typeUserName(WebDriver driver, String username) {
        userNameTxt(driver).sendKeys(username);
    }


    public void typePassword(WebDriver driver, String password) {
        passwordTxt(driver).sendKeys(password);
    }


    public void clickLoginButton(WebDriver driver) {
        loginButton(driver).click();
    }


}
