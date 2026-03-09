package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{


    // Элементы на странице
    private By searchBox = By.id("search");
    private By profileMenu = By.id("profile");
    private By logoutButton = By.id("logout");

    public HomePage(WebDriver driver) {
        super(driver); // driver берём из BasePage
    }

    // Методы действий на странице
    public void search(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }

    public void logout() {
        driver.findElement(profileMenu).click();
        driver.findElement(logoutButton).click();
    }
}
