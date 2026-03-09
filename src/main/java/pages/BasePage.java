package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected By searchInput = By.xpath("//input[@placeholder='Search']");

    public void enterSearchText(String text) {
        driver.findElement(searchInput).sendKeys(text);
    }

}