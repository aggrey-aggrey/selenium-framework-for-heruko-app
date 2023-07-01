import org.aggrey.Pages.AddRemoveElementPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class AddRemoveElementTest {
    WebDriver driver;
    private String baseUrl = "https://the-internet.herokuapp.com/add_remove_elements/";
    AddRemoveElementPage addRemovePage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mtand\\Projects\\QA\\selenium\\created\\heroku-app-selenium-test\\src\\main\\java\\org\\aggrey\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(baseUrl);
        addRemovePage = new AddRemoveElementPage(driver);

    }

    @Test
    public void addElementTest() throws InterruptedException {
        addRemovePage.clickOnAddElementButton(driver);
        addRemovePage.deleteElementButton(driver);
      //  assert(addRemovePage.deleteElementButton(driver).isDisplayed());
    }

     @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
