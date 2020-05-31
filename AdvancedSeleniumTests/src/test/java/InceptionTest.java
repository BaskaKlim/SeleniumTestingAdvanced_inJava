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

    public void testMultipleWindowsShowing(){
        driver.findElement(By.id("letsGoDeeper")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfWindowsToBe(2));

    }
}
