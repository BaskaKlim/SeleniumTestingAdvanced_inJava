package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.*;

public class InceptionTest extends TestBase {

    JavascriptExecutor js;

    @Before
    public void openUp() {
        driver.get(BASE_URL + "inception.php");
        js = ((JavascriptExecutor) driver);

    }

    @Test

    public void testMultipleWindowsShowing() {
        //test variables inicialization
        String parentWindow = driver.getWindowHandle();

        //action
        driver.findElement(By.id("letsGoDeeper")).click();

        //wait for all windows I expected
        new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfWindowsToBe(2));

        //switch to new window to test webelement input
        driver.getWindowHandles();
        for (int i = 0; i < 5; i++) {

            for (String window : driver.getWindowHandles()) {
                driver.switchTo().window(window);

            }
            // test action
            driver.findElement(By.xpath("//input[1]")).sendKeys("testovaci text");
            driver.findElement(By.id("letsGoDeeper")).click();
        }
        driver.close();
        driver.switchTo().window(parentWindow);
    }

}
