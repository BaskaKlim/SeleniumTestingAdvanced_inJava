package test;

import java.util.concurrent.atomic.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import com.google.code.tempusfugit.concurrency.*;
import com.google.code.tempusfugit.concurrency.annotations.*;

public class RunConcurrentlyTests extends TestBase {

    @Rule
    public RepeatingRule repeatedly = new RepeatingRule();

    private static final AtomicInteger counter = new AtomicInteger();

    @Before

    public void OpenUp() {
        driver.get("http://localhost:8888/waitforit.php");

    }

    @Test
    @Repeating(repetition = 10)

    public void waitForInputTest() throws InterruptedException {

        driver.findElement(By.id("startWaitForText")).click();


        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(
                        By.id("waitForTextInput"), "value", "dary !!!"));

        
        System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));

        counter.getAndIncrement();
        System.out.println(counter);
    }
}


