package test;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.*;
import helpers.*;

public class PrimeTest extends TestBase {

    private static final String TEST_DATA_PATH = "src/test/resources/data/data.xlsx";
    private static final String SHEET = "prime";

    @Before
    public void openUp() {
        getDriver().get(BASE_URL + "primenumber.php");

    }

    @Test
    public void itShoudlTestIfNumberIsPrime() throws IOException {

        WebElement numberInput = getDriver().findElement(By.xpath("//input[@type='number']"));
        WebElement button = getDriver().findElement(By.cssSelector("button.btn"));

        //preparation of data - inicialization of ExelReader
        ExcelReader primeExcelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = primeExcelReader.getSheetByName(SHEET);

        //read each cell in row from sheet prime
        for (Row cells : sheet) {
            if (cells.getRowNum() == 0) {
                continue;
            }

            //inicialize variables for test
            int number = (int) cells.getCell(0).getNumericCellValue();
            Boolean expectedPrimeStatus = cells.getCell(1).getBooleanCellValue();

            // actions: set up inputs -> clear, send the value from current excel cell,click on prime validation button
            numberInput.clear();
            numberInput.sendKeys(String.valueOf(number));
            button.click();

            // check the values of our test - compare result text variations according to expectPrimeStatus
            checkResult(expectedPrimeStatus);
        }

    }

    /**        private methods                              **/
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
