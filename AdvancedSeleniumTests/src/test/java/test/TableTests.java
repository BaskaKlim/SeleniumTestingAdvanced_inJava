package test;

import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;

public class TableTests extends TestBase {

    @Before
    public void openUp() {
        driver.get("http://localhost:8888/tabulka.php");
    }

    @Test

    public void testHighLight() {
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : rows) {
            if (row.getText().contains("Florian")) {
                highlight(row);
            }

        }
    }

    private Object highlight(WebElement row) {
        return ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", row);
    }

}
