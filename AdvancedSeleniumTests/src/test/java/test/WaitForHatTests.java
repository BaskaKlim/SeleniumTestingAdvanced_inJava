package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.*;

public class WaitForHatTests extends TestBase {

    @Before
    public void openUp() {
        getDriver().get(BASE_URL + "prestige.php");
    }

    @Test
    public void itShouldWaitForDisappearAndShowingHatAgain() {
        //actions
        getDriver().findElement(By.cssSelector("div.hat img")).click();

        //wait for elements to be disappear and visible again
        new WebDriverWait(getDriver(),5)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.hat img")));

        new WebDriverWait(getDriver(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.hat img")));
    }
    

}
