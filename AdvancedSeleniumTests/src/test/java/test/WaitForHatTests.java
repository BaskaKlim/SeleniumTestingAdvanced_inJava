package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.*;

public class WaitForHatTests extends TestBase {

    @Before
    public void openUp() {
        driver.get(BASE_URL + "prestige.php");
    }

    @Test
    public void itShouldWaitForDisappearAndShowingHatAgain() {
        //actions
        driver.findElement(By.cssSelector("div.hat img")).click();

        //wait for elements to be disappear and visible again
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.hat img")));

        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.hat img")));
    }
    

}
