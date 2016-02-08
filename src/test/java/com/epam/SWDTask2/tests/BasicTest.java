package com.epam.SWDTask2.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Natallia_Ramanchyk on 1/26/2016.
 */
public class BasicTest {
    WebDriver driver;
    public static final String URL = "https://www.travelsupermarket.com/";

    @BeforeMethod
    public void prepare() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
