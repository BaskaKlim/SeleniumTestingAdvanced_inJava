import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class InceptionTest extends TestBase {

    JavascriptExecutor js;

    @Before
    public void openUp() {
        driver.get("http://localhost:8888/inception.php");
        js = ((JavascriptExecutor) driver);

    }

    @Test

    public void testMultipleWindowsShowing() {
        driver.findElement(By.id("letsGoDeeper")).click();

        //wait for all windows I expected
        new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfWindowsToBe(2));

        //switch to new window to test webelement input
        driver.getWindowHandles();
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);

        }
        // test action
        driver.findElement(By.xpath("//input[1]")).sendKeys("testovaci text");

    }
}
