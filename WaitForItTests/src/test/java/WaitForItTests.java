import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import static junit.framework.TestCase.*;

public class WaitForItTests {

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

    
    @Test
    public void waitForInputTest() throws InterruptedException {
        driver.get("http://localhost:8888/waitforit.php");
        driver.findElement(By.id("startWaitForText")).click();
       new WebDriverWait(driver,5).until(ExpectedConditions.attributeToBe(By.id("waitForTextInput"),"value","dary !!!"));
        System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));
    }
}
