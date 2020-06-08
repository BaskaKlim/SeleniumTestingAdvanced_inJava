package test;

import org.junit.*;
import org.openqa.selenium.*;

public class SinCityTests extends TestBase {

    @Before

    public void OpenUp() {
        driver.get("http://localhost:8888/sincity.php");

    }

    @Test

    public void testNewSin() {
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Zabil som pavuka");
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys("Jakub Milek");
        driver.findElement(By.name("message")).sendKeys("Zlakol som sa, ked ku mne v noci prisiel a zabil som ho");
        //driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

}
