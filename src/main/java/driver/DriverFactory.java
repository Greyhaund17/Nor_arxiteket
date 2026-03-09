package driver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class DriverFactory {

    private static JsonNode config;

    static {
        try (InputStream is = DriverFactory.class.getClassLoader().getResourceAsStream("appsettings.json")) {
            if (is == null) {
                throw new RuntimeException("Cannot find appsettings.json in resources!");
            }
            ObjectMapper mapper = new ObjectMapper();
            config = mapper.readTree(is);
        } catch (IOException e) {
            throw new RuntimeException("Cannot load appsettings.json", e);
        }
    }

    public DriverFactory(WebDriver driver) {
    }

    public static WebDriver createDriver() {
        String browser = System.getProperty("browser",
                config.get("TestSettings").get("Browser").asText()).toLowerCase();
        int implicitWait = config.get("TestSettings").get("ImplicitWaitSeconds").asInt();

        WebDriver driver;
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().window().maximize();
        return driver;
    }

    public static String getBaseUrl() {
        return config.get("TestSettings").get("BaseUrl").asText();
    }
}