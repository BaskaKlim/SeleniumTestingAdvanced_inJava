package test;

import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import base.*;
import models.*;

public class SinCityTests extends TestBase {

    public List<String> spiderSinTags = new ArrayList<String>();

    @Before

    public void OpenUp() {
        driver.get(BASE_URL + "sincity.php");

    }

    @Test

    public void testNewSin() throws InterruptedException {
        Sin spiderSin = new Sin("Zabil som pavuka",
                "Jakub Milek",
                "Zlakol som sa, ked ku mne v noci prisiel a zabil som ho");

        spiderSin.setTitle("Zabil som uz druheho pavuka");
        spiderSinTags.add("murder");
        spiderSinTags.add("robbery");

        spiderSin.setTags(spiderSinTags);

        fillSinInformation(spiderSin);
        markTag(spiderSinTags);

    }

    private void fillSinInformation(Sin sin) {
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys(sin.getTitle());
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys(sin.getAuthor());
        driver.findElement(By.name("message")).sendKeys(sin.getMessage());
    }

    private void markTag(List<String> spiderSinTags) throws InterruptedException {

        for (String spiderSinTag : spiderSinTags) {
            driver.findElement(By.xpath("//input[@value='" + spiderSinTag + "']")).click();
            Thread.sleep(5000);
        }
    }

}
