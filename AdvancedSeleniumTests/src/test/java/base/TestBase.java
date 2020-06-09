package base;

import org.junit.*;
import org.openqa.selenium.*;

import static junit.framework.TestCase.*;

public class TestBase {

    public StringBuffer verificationErrors = new StringBuffer();
    public static final String BASE_URL = "http://localhost:8888/";

    public WebDriver getDriver() {
        return WebDriverSingleton.getWebDriverInstance();
    }

    @Before

    public void setUp() {
        WebDriverSingleton.getWebDriverInstance();
        WebDriverSingleton.getWebDriverInstance().manage().window().maximize();

    }

    @After

    public void tearDown() {
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
        WebDriverSingleton.getWebDriverInstance().close();
        WebDriverSingleton.getWebDriverInstance().quit();
    }

}
