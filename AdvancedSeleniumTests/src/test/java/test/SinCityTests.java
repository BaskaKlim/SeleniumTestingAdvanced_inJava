package test;

import org.junit.*;
import org.openqa.selenium.*;
import models.*;

public class SinCityTests extends TestBase {

    @Before

    public void OpenUp() {
        driver.get("http://localhost:8888/sincity.php");

    }

    @Test

    public void testNewSin() {
        Sin sin = new Sin("Zabil som pavuka",
                "Jakub Milek",
                "Zlakol som sa, ked ku mne v noci prisiel a zabil som ho");
        fillSinInformation(sin);

    }

    private void fillSinInformation(String title, String author, String message) {
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys(author);
        driver.findElement(By.name("message")).sendKeys(message);
    }

    private void fillSinInformation(Sin sin) {
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys(sin.getTitle());
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys(sin.getAuthor());
        driver.findElement(By.name("message")).sendKeys(sin.getMessage());
    }

}
