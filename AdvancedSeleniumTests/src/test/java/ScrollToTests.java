import org.junit.*;
import org.openqa.selenium.*;

public class ScrollToTests extends TestBase {

    @Before
    public void openUp() {
        driver.get("http://localhost:8888/tabulka.php");
    }

    @Test

    public void scrollToLastRow() {
        WebElement lastRow = driver.findElement(By.xpath("//table/tbody/tr[last()]"));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()", lastRow);
    }

    @Test

    public void scrollToExactRow() {
        WebElement lastRow = driver.findElement(By.xpath("//table/tbody/tr[5]"));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true)", lastRow);
    }
}
