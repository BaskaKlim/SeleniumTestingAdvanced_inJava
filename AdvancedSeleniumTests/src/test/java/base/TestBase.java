package base;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static junit.framework.TestCase.*;

public class TestBase {

    public WebDriver driver;
    public StringBuffer verificationErrors = new StringBuffer();

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After

    public void tearDown() {
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
        driver.close();
        driver.quit();
    }

}
