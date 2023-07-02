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
    By logoutBtn = By.cssSelector("a[href='/logout'");
    By invalidLoginMsg = By.cssSelector("#flash");

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

    public WebElement invalidLoginMessage(WebDriver driver){
        element = driver.findElement((By) invalidLoginMsg);
        return element;
    }

    public WebElement loginButton(WebDriver driver) {
        element = driver.findElement((By) loginBtn);
        return element;
    }

    private WebElement logoutButton(WebDriver driver) {
        element = driver.findElement((By) logoutBtn);
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

    public void clickLogoutButton(WebDriver driver){
        logoutButton(driver).click();
    }




}
