package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.*;

public class BlurTest extends TestBase {

    @Before

    public void OpenUp() {
        getDriver().get(BASE_URL + "waitforit.php");

    }

    @Test
    //TODO: otestovat funkciu blur, pouziva sa pri formularoch napr. pri mene,hesle, emaily ked vystupim z inputu
    // odoslu sa mi dane data na server a validuju

    public void testBlur() {
        //find elements to test
        getDriver().findElement(By.id("waitForBlur")).sendKeys("Testovaci text");

        //make tested action
        JavascriptExecutor js = ((JavascriptExecutor)  getDriver());
        js.executeScript("arguments[0].blur()",  getDriver().findElement(By.id("waitForBlur")));

        //wait for expected result
        new WebDriverWait( getDriver(), 5).until(ExpectedConditions.attributeToBe
                ( getDriver().findElement(By.id("waitForBlur")), "value", "blured!"));
    }

}
