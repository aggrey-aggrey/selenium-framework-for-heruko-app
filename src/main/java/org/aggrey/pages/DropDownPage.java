package org.aggrey.pages;

import com.sun.jdi.connect.Connector;
import org.aggrey.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage extends TestBase {
    private static WebElement element;
    By dropDownTxt = By.cssSelector("select#dropdown");

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement dropDownTxt(WebDriver driver) {
        element = driver.findElement(dropDownTxt);
        return element;
    }

    public void clickDropDownOption(WebDriver driver) {
        dropDownTxt(driver).click();
        Select select = new Select(dropDownTxt(driver));
        select.selectByValue(String.valueOf(2));
    }

    public List<String> printAllSelectableOptions(){
        Select select = new Select(dropDownTxt(driver));
        List<WebElement> options = select.getOptions();
        List<String> optionList = options.stream()
                .map(option -> option.getText()).collect(Collectors.toList());
        return optionList;

    }


}
