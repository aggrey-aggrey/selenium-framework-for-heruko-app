import org.aggrey.pages.DropDownPage;
import org.aggrey.testbase.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownPageTest extends TestBase {
    private String dropDownUrl = "https://the-internet.herokuapp.com/dropdown";
    DropDownPage dropDownPage;

    @BeforeTest
    public void setUp() {
        dropDownPage = new DropDownPage(driver);
        dropDownPage.selectBrowser("chrome", dropDownUrl, 10);
    }

    @Test
    public void selectDropDownOptions(){
        System.out.println(dropDownPage.printAllSelectableOptions());
        dropDownPage.clickDropDownOption(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
