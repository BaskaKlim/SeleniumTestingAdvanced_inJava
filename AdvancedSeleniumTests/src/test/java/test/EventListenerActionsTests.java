package test;

import org.junit.*;
import org.openqa.selenium.*;
import base.*;

public class EventListenerActionsTests extends TestBase {
    @Before

    public void OpenUp() {
        getDriver().get(BASE_URL + "waitforit.php");

    }

    @Test

    public void testEventListenerActionForClick() {
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("arguments[0].click()", getDriver().findElement(By.id("startWaitForText")));

    }


}
