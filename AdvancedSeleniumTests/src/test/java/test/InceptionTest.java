package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.*;

public class InceptionTest extends TestBase {

    JavascriptExecutor js;

    @Before
    public void openUp() {
        getDriver().get(BASE_URL + "inception.php");
        js = ((JavascriptExecutor) getDriver());

    }

    @Test

    public void testMultipleWindowsShowing() {
        //test variables inicialization
        String parentWindow = getDriver().getWindowHandle();

        //action
        getDriver().findElement(By.id("letsGoDeeper")).click();

        //wait for all windows I expected
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.numberOfWindowsToBe(2));

        //switch to new window to test webelement input
        getDriver().getWindowHandles();
        for (int i = 0; i < 5; i++) {

            for (String window : getDriver().getWindowHandles()) {
                getDriver().switchTo().window(window);

            }
            // test action
            getDriver().findElement(By.xpath("//input[1]")).sendKeys("testovaci text");
            getDriver().findElement(By.id("letsGoDeeper")).click();
        }
        getDriver().close();
        getDriver().switchTo().window(parentWindow);
    }

}
