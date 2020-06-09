package test;

import org.junit.*;
import org.openqa.selenium.*;
import base.*;

public class EventListenerActionsTests extends TestBase {
    @Before

    public void OpenUp() {
        driver.get(BASE_URL + "waitforit.php");

    }

    @Test

    public void testEventListenerActionForClick() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click()", driver.findElement(By.id("startWaitForText")));

    }


}
