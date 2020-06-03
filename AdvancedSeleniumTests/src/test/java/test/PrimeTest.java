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

        // basic automation test
        WebElement numberInput = driver.findElement(By.xpath("//input[@type='number']"));
        WebElement button = driver.findElement(By.cssSelector("button.btn"));
        WebElement resultText = driver.findElement(By.cssSelector("div.result"));

        numberInput.sendKeys("5");
        button.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfAllElements());


        //preparation of data - inicialization of ExelReader and test if it works
        ExcelReader primeExcelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = primeExcelReader.getSheetByName(SHEET);

        for (Row cells : sheet) {
            if (cells.getRowNum() == 0) {
                continue;
        }
        System.out.println(cells.getCell(0).getNumericCellValue());
    }

}
}
