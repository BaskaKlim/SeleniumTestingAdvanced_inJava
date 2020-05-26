import org.junit.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class WaitForItTest {
    public WebDriver driver;

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver/");
        driver = new ChromeDriver();
    }

    @After

    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    private void testForInputText() {
        driver.get("http://localhost:8888/waitforit.php");

    }

}
