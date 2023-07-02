import org.aggrey.pages.LoginPage;
import org.aggrey.testbase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest extends TestBase {
 //  WebDriver driver;
    private String loginUrl = "https://the-internet.herokuapp.com/login";
    LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        loginPage = new LoginPage(driver);
        loginPage.selectBrowser("chrome", loginUrl, 10);
    }

    @Test
    public void login() {
        //note the username and password are public on heruko website
        loginPage.typeUserName(driver, "tomsmith");
        loginPage.typePassword(driver, "SuperSecretPassword!");
        loginPage.clickLoginButton(driver);
        loginPage.clickLogoutButton(driver);
    }

    @Test
    public void invalidLogin(){
        loginPage.typeUserName(driver, "");
        loginPage.typePassword(driver, "");
        loginPage.clickLoginButton(driver);
        loginPage.invalidLoginMessage(driver).isDisplayed();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
