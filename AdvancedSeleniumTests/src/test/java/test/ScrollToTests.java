package test;

import org.junit.*;
import org.openqa.selenium.*;
import base.*;

public class ScrollToTests extends TestBase {

    JavascriptExecutor js;

    @Before
    public void openUp() {
        getDriver().get(BASE_URL + "tabulka.php");
        js = ((JavascriptExecutor) getDriver());
    }

    @Test

    public void scrollToLastRow() {
        WebElement lastRow = getDriver().findElement(By.xpath("//table/tbody/tr[last()]"));
        js.executeScript("arguments[0].scrollIntoView()", lastRow);
    }

    @Test

    public void scrollToExactRow() {
        WebElement lastRow = getDriver().findElement(By.xpath("//table/tbody/tr[5]"));
        js.executeScript("arguments[0].scrollIntoView(true)", lastRow);
    }

    @Test

    public void scrollDownByExactNumberOfPixel() {
        for (int i = 0; i < 4; i++) {
            js.executeScript("window.scrollBy(0,200)");
        }
    }

    @Test

    public void scrollToEndByUsingPixelHeightOfWebPage() {
        //find out how many pixel has dynamic website for testing its end element
        System.out.println(js.executeScript("return document.body.scrollHeight"));
        //declare long variable for pageBodyHeight
        long pageBodyHeight = (long) js.executeScript("return document.body.scrollHeight");
        //scroll down to the end of the page by using javascript from java program
        js.executeScript("window.scrollBy(0," + pageBodyHeight + " )") ;

    }
}
