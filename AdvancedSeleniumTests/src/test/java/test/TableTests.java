package test;

import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import base.*;

public class TableTests extends TestBase {

    @Before
    public void openUp() {
        getDriver().get(BASE_URL + "tabulka.php");
    }

    @Test

    public void testHighLight() {
        List<WebElement> rows = getDriver().findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : rows) {
            if (row.getText().contains("Florian")) {
                highlight(row);
            }

        }
    }

    private Object highlight(WebElement row) {
        return ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", row);
    }

}
