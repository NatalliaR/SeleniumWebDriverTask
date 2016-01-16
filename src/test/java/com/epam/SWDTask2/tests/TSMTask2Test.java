package com.epam.SWDTask2.tests;

import com.epam.SWDTask2.pages.TSMHomePage;
import com.epam.SWDTask2.pages.TSMHotelPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertEquals;

/**
 * Created by Natallia_Ramanchyk on 1/15/2016.
 */
public class TSMTask2Test {
    private WebDriver driver;

    public static final String URL = "https://www.travelsupermarket.com/";
    public static final String dest = "dub";
    public static final String destValue = "528cbf04e4b0ec1df5083fbc";
    public static final String checkIn = "20 Jan 16";
    public static final String checkOut = "27 Jan 16";
    public static final String guests = "2 adults in 1 room";
    public static final String destTest = "Dubai";
    public static final String checkInTest = "20th Jan";
    public static final String checkOutTest = "27th Jan";

    @Test
    public void prepare() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        TSMHomePage tsmHomePage = new TSMHomePage(driver);
        tsmHomePage.hotelSearch(dest, checkIn, checkOut, guests);
        TSMHotelPage tsmHotelPage = new TSMHotelPage(driver);
        tsmHotelPage.waitResultsUploaded();
        assertEquals(tsmHotelPage.verifyHotelsTitle1(), destTest, "Invalid result");
        assertEquals(tsmHotelPage.verifyHotelsTitle2(), checkInTest + " to " + checkOutTest + " - Change search", "Invalid result");
        driver.close();
        driver.quit();
    }
}

