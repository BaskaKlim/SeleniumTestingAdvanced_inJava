package test;

import java.util.*;
import java.util.stream.*;
import org.junit.*;
import org.openqa.selenium.*;
import base.*;

public class StreamTests extends TestBase {

    @Before
    public void openUp() {
        getDriver().get(BASE_URL + "tabulka.php");
    }

    @Test

    public void getExactNamesFromTable() {
        List<WebElement> rows = getDriver().findElements(By.xpath("//table/tbody/tr"));
        rows.stream().filter(row -> getFirstName(row).equals("Vendelin"))
                .forEach(row -> System.out.println(getSurname(row)));
    }


    @Test

    public void getExactNamesToTheListOfString(){
        List<WebElement> rows = getDriver().findElements(By.xpath("//table/tbody/tr"));
        List<String> vendelinsSurnames = new ArrayList<>();

        vendelinsSurnames = rows.stream().filter(row -> getFirstName(row).equals("Vendelin"))
                .map(row -> getSurname(row))
                .collect(Collectors.toList());
        System.out.println(vendelinsSurnames);
    }


    //funkcia na vybranie stlpca s menom, s parametrom webelement riadok
    private String getFirstName(WebElement element) {
        return element.findElement(By.xpath("./td[2]")).getText();
    }

    private String getSurname(WebElement element) {
        return element.findElement(By.xpath("./td[3]")).getText();
    }

}
