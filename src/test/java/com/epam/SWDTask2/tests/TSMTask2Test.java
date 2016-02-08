package com.epam.SWDTask2.tests;

import com.epam.SWDTask2.utils.ScreenShotUtils;
import com.epam.SWDTask2.pages.TSMHomePage;
import com.epam.SWDTask2.pages.TSMHotelPage;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

/**
 * Created by Natallia_Ramanchyk on 1/15/2016.
 */
public class TSMTask2Test extends BasicTest {


    public static final String dest = "dub";
    public static final String destValue = "528cbf04e4b0ec1df5083fbc";
    public static final String checkIn = "10 Feb 16";
    public static final String checkOut = "17 Feb 16";
    public static final String guests = "2 adults in 1 room";
    public static final String destTest = "Dubai";
    public static final String checkInTest = "10th Feb";
    public static final String checkOutTest = "17th Feb";

    @Test
    public void testHotelSearch() throws InterruptedException {
        TSMHomePage tsmHomePage = new TSMHomePage(driver);
        tsmHomePage.goToHotelsTab();
        tsmHomePage.enterHotelDestination(dest);
        tsmHomePage.fillingHotelSearch(checkIn, checkOut, guests);
        tsmHomePage.goToHotelSearch();
        TSMHotelPage tsmHotelPage = new TSMHotelPage(driver);
        tsmHotelPage.waitResultsUploaded();
        ScreenShotUtils.takeScreenShotWithHighlightElement(tsmHotelPage.getTitleWhereHotels(),driver);
        assertEquals(tsmHotelPage.textWhereHotelsFromTitle(), destTest, "Invalid result");
        ScreenShotUtils.takeScreenShotWithHighlightElement(tsmHotelPage.getTitleDurationFromTo(),driver);
        assertEquals(tsmHotelPage.textDurationFromToFromTitle(), checkInTest + " to " + checkOutTest + " - Change search", "Invalid result");
    }

}

