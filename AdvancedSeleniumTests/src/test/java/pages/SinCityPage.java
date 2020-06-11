package pages;

import java.util.*;
import org.openqa.selenium.*;
import base.*;
import enumerators.*;
import models.*;

public class SinCityPage {

    WebDriver driver;
    //konstruktor
    public SinCityPage(){
    driver = WebDriverSingleton.getWebDriverInstance();
    }
   public  void fillSinInformation(Sin sin) {
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys(sin.getTitle());
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys(sin.getAuthor());
        driver.findElement(By.name("message")).sendKeys(sin.getMessage());
    }


    public void markTag(List<SinTag> tags) throws InterruptedException {

        for (SinTag tag : tags) {
            driver.findElement(By.xpath("//input[@value='" + tag.getXpathValue() + "']")).click();
            Thread.sleep(5000);
        }
    }



}
