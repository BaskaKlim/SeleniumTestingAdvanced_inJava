import org.junit.*;
import org.openqa.selenium.*;

public class EventListenerActionsTests extends TestBase {
    @Before

    public void OpenUp() {
        driver.get("http://localhost:8888/waitforit.php");

    }

    @Test

    public void testEventListenerActionForClick() {
        
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click()", driver.findElement(By.id("startWaitForText")));

    }


}
