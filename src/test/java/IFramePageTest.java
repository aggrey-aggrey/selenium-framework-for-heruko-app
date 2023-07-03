import org.aggrey.pages.IFramePage;
import org.aggrey.pages.LoginPage;
import org.aggrey.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IFramePageTest extends TestBase {
    private String iframepageUrl = "https://the-internet.herokuapp.com/iframe";

    IFramePage iFramePage;

    @BeforeClass
    public void setUp() {
        iFramePage = new IFramePage(driver);
        iFramePage.selectBrowser("chrome", iframepageUrl, 10);
    }

    @Test
    public void switchToIframe() {
        String typedText = "Type something in IframeTextBox";
        iFramePage.switchToIframe();
        WebElement iframeTextBox = driver.findElement(By.cssSelector("body#tinymce"));
        iframeTextBox.click();
        iframeTextBox.clear();
        iframeTextBox.sendKeys(typedText);
        String result = iframeTextBox.getText();
        Assert.assertEquals(typedText, result);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
