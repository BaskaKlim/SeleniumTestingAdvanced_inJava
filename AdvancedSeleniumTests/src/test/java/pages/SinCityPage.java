package pages;

import org.openqa.selenium.*;
import base.*;
import models.*;

public class SinCityPage {

    WebDriver driver;
    //konstruktor
    public SinCityPage(){
    driver = WebDriverSingleton.getWebDriverInstance();
    }
    private void fillSinInformation(Sin sin) {
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys(sin.getTitle());
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys(sin.getAuthor());
        driver.findElement(By.name("message")).sendKeys(sin.getMessage());
    }


}
