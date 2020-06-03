import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class PrimeTest extends TestBase {

    @Before
    public void openUp() {
        driver.get("http://localhost:8888/primenumber.php");

    }

    @Test
    public void itShoudlTestIfNumberIsPrime() {
        WebElement numberInput = driver.findElement(By.xpath("//input[@type='number']"));
        WebElement button = driver.findElement(By.cssSelector("button.btn"));
        WebElement resultText = driver.findElement(By.cssSelector("div.result"));

        numberInput.sendKeys("5");
        button.click();
        new WebDriverWait(driver,5).until(ExpectedConditions.invisibilityOfAllElements());
     
    }
}
