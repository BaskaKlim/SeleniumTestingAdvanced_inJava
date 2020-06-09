package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class WebDriverSingleton {

    private static WebDriver driver;

    private static void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    private static WebDriver getWebDriverInstance() {
        if (driver == null) {
            initialize();
        }
        return driver;
    }

}
