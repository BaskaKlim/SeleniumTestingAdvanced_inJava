package test;

import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import base.*;
import enumerators.*;
import models.*;
import pages.*;

public class SinCityTests extends TestBase {

    @Before

    public void OpenUp() {
        getDriver().get(BASE_URL + "sincity.php");

    }

    @Test

    public void testNewSin() throws InterruptedException {
        SinCityPage sinCityPage = new SinCityPage();

        Sin spiderSin = new Sin("Zabil som pavuka",
                "Jakub Milek",
                "Zlakol som sa, ked ku mne v noci prisiel a zabil som ho");

        spiderSin.setTitle("Zabil som uz druheho pavuka");

        List<SinTag> spiderSinTags = new ArrayList<SinTag>();
        spiderSinTags.add(SinTag.MURDER);
        spiderSinTags.add(SinTag.ROBBERY);

        spiderSin.setTags(spiderSinTags);

        sinCityPage.fillSinInformation(spiderSin);
        markTag(spiderSin.getTags());

    }


    private void markTag(List<SinTag> tags) throws InterruptedException {

        for (SinTag tag : tags) {
            getDriver().findElement(By.xpath("//input[@value='" + tag.getXpathValue() + "']")).click();
            Thread.sleep(5000);
        }
    }

}
