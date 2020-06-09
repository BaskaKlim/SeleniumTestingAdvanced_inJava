package test;

import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.*;

//anotacia pre paramatricky test
@RunWith(Parameterized.class)
public class ParameterTests extends TestBase {

    int number;
    boolean expectedPrimeStatus;

    //parametricka metoda, ktora nam vrati paramatre
    @Parameterized.Parameters
    public static List<Object> getData() {
        return Arrays.asList(new Object[][] {{1, true}, {3, true}, {55, false}, {67, true}, {782, false}, {12, false}});
    }

    //konstruktor, ktory sa mi vzdy pri zavolani triedy spusti a preda jej parameter vdaka anotacii vyssie
    public ParameterTests(int number, boolean expectedPrimeStatus) {
        this.number = number;
        this.expectedPrimeStatus = expectedPrimeStatus;

    }

    @Before
    public void openUp() {
        getDriver().get(BASE_URL + "primenumber.php");

    }

    @Test
    public void primeNumberTestUsingParameters() {
        WebElement numberInput = getDriver().findElement(By.xpath("//input[@type='number']"));
        WebElement button = getDriver().findElement(By.cssSelector("button.btn"));

        numberInput.clear();
        numberInput.sendKeys(String.valueOf(number));
        button.click();

        checkResult(expectedPrimeStatus);
    }

    /**
     * private methods
     **/

    private void checkResult(boolean expectedPrimeStatus) {
        if (expectedPrimeStatus == true) {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.
                    visibilityOfElementLocated(By.xpath("//div[text()='Optimus approves']")));
        } else {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.
                    visibilityOfElementLocated(By.xpath("//div[text()='Optimus is sad']")));

        }
    }

}
