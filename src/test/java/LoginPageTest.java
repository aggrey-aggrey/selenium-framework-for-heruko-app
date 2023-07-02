import org.aggrey.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {
    WebDriver driver;
    private String loginUrl = "https://the-internet.herokuapp.com/login";
    LoginPage loginPage;

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.chromedriver.exe", "C:\\Users\\mtand\\Projects\\QA\\selenium\\created\\heroku-app-selenium-test\\src\\main\\java\\org\\aggrey\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(loginUrl);
        loginPage = new LoginPage(driver);
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
