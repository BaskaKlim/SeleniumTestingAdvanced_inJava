package test;

import org.junit.*;
import org.junit.experimental.categories.*;
import org.junit.rules.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.*;
import categories.*;

public class WaitForItTests extends TestBase {

    //nastavim si pravidlo, ze ocakavam expeption
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before

    public void OpenUp() {
        getDriver().get(BASE_URL + "waitforit.php");

    }

    @Test
    public void testTitle(){
        String title  = getDriver().findElement(By.xpath("//h1")).getText();
        //v tomto teste ocakavam tento konkretny typ chyby - exception
        expectedException.expect(ComparisonFailure.class);
        expectedException.expectMessage("Title nesedi");

        Assert.assertEquals("Title nesedi", "WAIT FOR IT !!!",title );

    }
    


    @Category(SmokeTests.class)
    @Test
    public void waitForInputTest() throws InterruptedException {
        //action that I am testing
        getDriver().findElement(By.id("startWaitForText")).click();

        //state that is expected
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.attributeToBe(
                        By.id("waitForTextInput"), "value", "dary !!!"));

        //check the value that is expected
        System.out.println(getDriver().findElement(By.id("waitForTextInput")).getAttribute("value"));
    }

    @Test

    public void waitForProperty() {
        //action that I am testing
        getDriver().findElement(By.id("startWaitForProperty")).click();

        //state that is expected
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.attributeContains
                        (getDriver().findElement(By.id("waitForProperty")),"class","error"));


        //assert the value that is expected
        Assert.assertFalse(getDriver().findElement(By.id("startWaitForProperty")).isEnabled());
        Assert.assertTrue(getDriver().findElement(By.id("startWaitForProperty")).isDisplayed());
    }

}
