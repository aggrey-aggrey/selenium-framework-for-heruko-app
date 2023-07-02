package org.aggrey.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    static final String drivePath = "\\src\\main\\java\\org\\aggrey\\drivers\\";

    public WebDriver getDriver(){
        return this.driver;
    }
    public void selectBrowser(String browserType, String appURL, int waitTime){
        switch (browserType){
            case  "chrome":
                driver = initChromeDriver(appURL, waitTime);
                break;
            case "firefox" :
                driver = initFireFox(appURL, waitTime);
                break;
            case "edge" :
                driver = initEdge(appURL, waitTime);
                break;
        }
    }

    private static  WebDriver initEdge(String appURL, int waitTime) {
        System.out.println("Launching Microsoft Edge with new profile..");
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + drivePath  + "msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
        return driver;

    }

    private static WebDriver initFireFox(String appURL, int waitTime) {
        System.out.println("Launching Firefox with new profile..");
       // System.setProperty("webdriver.gecko.driver",);
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(System.getProperty("user.dir") + drivePath + "geckodriver_win64.exe");
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
        return driver;
    }

    private static WebDriver initChromeDriver(String appURL, int waitTime) {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir") + drivePath  + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("driver after  driver = new ChromeDriver() = " + driver);
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
        return driver;
    }


}
