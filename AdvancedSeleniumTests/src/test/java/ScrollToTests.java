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

    @Test

    public void scrollDownByExactNumberOfPixel() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        for (int i = 0; i < 4; i++) {
            js.executeScript("window.scrollBy(0,200)");
        }
    }

    @Test

    public void scrollToEndByUsingPixelHeightOfWebPage() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
         //find out how many pixel has dynamic website for testing its end element
        System.out.println(js.executeScript("return document.body.scrollHeight"));

        
    }
}
