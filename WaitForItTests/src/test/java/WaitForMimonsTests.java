import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitForMimonsTests extends TestBase {


    @Before
    public void OpenUp() {
        driver.get("http://localhost:8888/minions.php");

    }


    @Test

    public void itShouldShowExactNumbersOfMimons(){
    //actions
        int numberOfMimons= 5;
        driver.findElement(By.xpath("//div/input[@type='number']")).sendKeys("5");
        driver.findElement(By.xpath("//div/button[contains(@class,'btn-warning')]")).click();

     //wait for elements to be displayed
     new WebDriverWait(driver,5).until(ExpectedConditions.numberOfElementsToBe((By.xpath("//div[@class='minions']//img")),numberOfMimons));

    //validate the expected values and actions

        Assert.assertEquals(numberOfMimons,
                driver.findElements(By.xpath("//div[@class='minions']//img")).size());
    }

}
