package test;

import java.util.*;
import org.junit.*;
import base.*;
import enumerators.*;
import models.*;
import pages.*;

public class SinCityTests extends TestBase {

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


        //test fill the sin and confest
        sinCityPage.openPage();
        sinCityPage.fillSinInformation(spiderSin);
        sinCityPage.markTag(spiderSin.getTags());
        sinCityPage.confessSin();
        sinCityPage.openSinDetail(spiderSin);
        sinCityPage.checkSinStatus(spiderSin);


    }


}
