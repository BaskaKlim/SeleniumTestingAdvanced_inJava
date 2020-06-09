package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.*;

public class WaitForMimonsTests extends TestBase {


    @Before
    public void openUp() {
        getDriver().get(BASE_URL + "minions.php");
    }

    @Test

    public void itShouldShowExactNumbersOfMimons(){
    //actions
        int numberOfMimons= 5;
        getDriver().findElement(By.xpath("//div/input[@type='number']")).sendKeys(String.valueOf(numberOfMimons));
        getDriver().findElement(By.xpath("//div/button[contains(@class,'btn-warning')]")).click();

     //wait for elements to be displayed
     new WebDriverWait(getDriver(),5)
             .until(ExpectedConditions.numberOfElementsToBe(
                     (By.xpath("//div[@class='minions']//img")),numberOfMimons));

    //validate the expected values and actions

        Assert.assertEquals(numberOfMimons,
                getDriver().findElements(By.xpath("//div[@class='minions']//img")).size());
    }

    @Test

    public void itShouldShowErrorMessageIfNoEnoughMimonsWillShow(){
        //actions
        int numberOfMimons= 10;
        getDriver().findElement(By.xpath("//div/input[@type='number']")).sendKeys("5");
        getDriver().findElement(By.xpath("//div/button[contains(@class,'btn-warning')]")).click();

        //wait for elements to be displayed  and declare error message for webdriverwait
        new WebDriverWait(getDriver(),5)
                .withMessage("Timeout waiting for number of mimons to be 10")
                .until(ExpectedConditions.numberOfElementsToBe(
                        (By.xpath("//div[@class='minions']//img")),numberOfMimons));

        //validate the expected values and actions

        Assert.assertEquals(numberOfMimons,
                getDriver().findElements(By.xpath("//div[@class='minions']//img")).size());
    }


}
