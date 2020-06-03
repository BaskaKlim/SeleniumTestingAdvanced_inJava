package test;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import helpers.*;

public class PrimeTest extends TestBase {

    private static final String TEST_DATA_PATH = "src/test/resources/data/data.xlsx";
    private static final String SHEET = "prime";

    @Before
    public void openUp() {
        driver.get("http://localhost:8888/primenumber.php");

    }

    @Test
    public void itShoudlTestIfNumberIsPrime() throws IOException {

        WebElement numberInput = driver.findElement(By.xpath("//input[@type='number']"));
        WebElement button = driver.findElement(By.cssSelector("button.btn"));

        //preparation of data - inicialization of ExelReader
        ExcelReader primeExcelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = primeExcelReader.getSheetByName(SHEET);

        //read each cell in row from sheet prime
        for (Row cells : sheet) {
            if (cells.getRowNum() == 0) {
                continue;
            }
         // set up inputs : clear, send the value from current excel cell
            numberInput.clear();
            numberInput.sendKeys(String.valueOf((int) cells.getCell(0).getNumericCellValue()));

         // click on prime validation button
            button.click();

         // check the values of our test - compare result text variations according to expectPrimeStatus
            Boolean expectedPrimeStatus = cells.getCell(1).getBooleanCellValue();

            if(expectedPrimeStatus == true){
                new WebDriverWait(driver,5).until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath("//div[text()='Optimus approves']")));
            }   else {
                new WebDriverWait(driver,5).until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath("//div[text()='Optimus is sad']")));
                
            }
        }

    }
}
