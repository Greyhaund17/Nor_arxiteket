package pages;

import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void searchInAdmin(String text) {
        enterSearchText(text);
    }
}
