import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitForItTests extends TestBase {

    @Before

    public void OpenUp() {
        driver.get("http://localhost:8888/waitforit.php");

    }

    @Test
    public void waitForInputTest() throws InterruptedException {
        //action that I am testing
        driver.findElement(By.id("startWaitForText")).click();

        //state that is expected
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(
                        By.id("waitForTextInput"), "value", "dary !!!"));

        //check the value that is expected
        System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));
    }

    @Test

    public void waitForProperty() {
        //action that I am testing
        driver.findElement(By.id("startWaitForProperty")).click();

        //state that is expected
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeContains
                        (driver.findElement(By.id("waitForProperty")),"class","error"));


        //assert the value that is expected
        Assert.assertFalse(driver.findElement(By.id("startWaitForProperty")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("startWaitForProperty")).isDisplayed());
    }

}
