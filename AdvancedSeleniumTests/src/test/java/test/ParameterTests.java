package test;

import java.util.*;
import org.junit.*;
import org.junit.runners.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ParameterTests extends TestBase {

    int number;
    Boolean expectedPrimeStatus;

    @Parameterized.Parameters
    public static List<Integer> getData(){
        return Arrays.asList(1,3,55,67,783,11);
    }

    //konstruktor, ktory sa mi vzdy pri zavolani triedy spusti a preda jej parameter vdaka anotacii vyssie
    public  ParameterTests(int number){
        this.number = number;

    }
    @Before
    public void openUp() {
        driver.get("http://localhost:8888/primenumber.php");

    }

    @Test
    public void primeNumberTestUsingParameters() {
        WebElement numberInput = driver.findElement(By.xpath("//input[@type='number']"));
        WebElement button = driver.findElement(By.cssSelector("button.btn"));


        numberInput.clear();
        numberInput.sendKeys(String.valueOf(number));
        button.click();

      
      //  checkResult(expectedPrimeStatus);
    }

    /**private methods**/
    
    private void checkResult(boolean expectedPrimeStatus) {
        if (expectedPrimeStatus == true) {
            new WebDriverWait(driver, 5).until(ExpectedConditions.
                    visibilityOfElementLocated(By.xpath("//div[text()='Optimus approves']")));
        } else {
            new WebDriverWait(driver, 5).until(ExpectedConditions.
                    visibilityOfElementLocated(By.xpath("//div[text()='Optimus is sad']")));

        }
    }

}
