package base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        driver.get(DriverFactory.getBaseUrl());
        LoginPage loginPage = new LoginPage(driver);
        homePage = loginPage.login("Admin", "admin123");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}