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
        Sin spiderSin = new Sin("Zabil som pavuka",
                "Jakub Milek",
                "Zlakol som sa, ked ku mne v noci prisiel a zabil som ho");

        spiderSin.setTitle("Zabil som uz druheho pavuka");
        fillSinInformation(spiderSin);
        markTag();

    }

    private void fillSinInformation(Sin sin) {
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys(sin.getTitle());
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys(sin.getAuthor());
        driver.findElement(By.name("message")).sendKeys(sin.getMessage());
    }

    private void markTag(){
        driver.findElement(By.xpath("//input[@value='murder']")).click();
    }

}
