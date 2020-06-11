package test;

import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import base.*;


public class StreamTests extends TestBase {

    @Before
    public void openUp() {
        getDriver().get(BASE_URL + "tabulka.php");
    }

    @Test

    public void testHighLight() {
        List<WebElement> rows = getDriver().findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : rows) {
            System.out.println(getFirstName(row));
        }
    }

    //funkcia na vybranie stlpca s menom, s parametrom webelement riadok
    private String getFirstName(WebElement element){
          return element.findElement(By.xpath("./td[2]")).getText();
    }

    private String getSurname(WebElement element){
        return element.findElement(By.xpath("./td[3]")).getText();
    }

}
