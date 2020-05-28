import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitForItTests extends TestBase{


    @Before

    public void OpenUp() {
        driver.get("http://localhost:8888/waitforit.php");

    }
    
    
    @Test
    public void waitForInputTest() throws InterruptedException {

        driver.findElement(By.id("startWaitForText")).click();
       new WebDriverWait(driver,5).until(ExpectedConditions.attributeToBe(By.id("waitForTextInput"),"value","dary !!!"));
        System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));
    }


}
