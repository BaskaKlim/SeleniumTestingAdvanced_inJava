package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.*;

public class BlurTest extends TestBase {

    @Before

    public void OpenUp() {
        driver.get(BASE_URL + "waitforit.php");

    }

    @Test
    //TODO: otestovat funkciu blur, pouziva sa pri formularoch napr. pri mene,hesle, emaily ked vystupim z inputu
    // odoslu sa mi dane data na server a validuju

    public void testBlur() {
        //find elements to test
        driver.findElement(By.id("waitForBlur")).sendKeys("Testovaci text");

        //make tested action
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].blur()", driver.findElement(By.id("waitForBlur")));

        //wait for expected result
        new WebDriverWait(driver, 5).until(ExpectedConditions.attributeToBe
                (driver.findElement(By.id("waitForBlur")), "value", "blured!"));
    }

}
