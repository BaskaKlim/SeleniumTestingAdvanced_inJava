package pages;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import base.*;
import enumerators.*;
import models.*;

public class SinCityPage {

    private WebDriver driver;

    @FindBy(name = "title")
    private WebElement titleInput;

    @FindBy(name = "author")
    private WebElement authorInput;

    @FindBy(name = "message")
    private WebElement messageInput;


    @FindBy(xpath = "//button[@type='submit']")
    private WebElement confessButton;

    //konstruktor
    public SinCityPage() {
        driver = WebDriverSingleton.getWebDriverInstance();
        PageFactory.initElements(driver, this);
    }

    public void fillSinInformation(Sin sin) {
        titleInput.sendKeys(sin.getTitle());
        authorInput.sendKeys(sin.getAuthor());
        messageInput.sendKeys(sin.getMessage());
    }

    public void markTag(List<SinTag> tags) throws InterruptedException {

        for (SinTag tag : tags) {
            driver.findElement(By.xpath("//input[@value='" + tag.getXpathValue() + "']")).click();
            Thread.sleep(5000);
        }
    }
    public void confessSin(){
        confessButton.click();
    }

}
