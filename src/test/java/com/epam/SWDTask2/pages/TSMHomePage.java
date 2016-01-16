package com.epam.SWDTask2.pages;

import com.epam.SWDTask2.tests.TSMTask2Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Natallia_Ramanchyk on 1/15/2016.
 */
public class TSMHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//button[contains(., 'Hotels')]")
    private WebElement hotelsTab;

    @FindBy(xpath = "//auto-complete[@id='hotelsDestinationField']/div/div")
    private WebElement uploadedHotelsDestination;

    @FindBy(id = "hotelsDestinationField_input")
    private WebElement hotelsDestination;

    @FindBy(xpath = "//button[@focus-on='" + TSMTask2Test.destValue + "']")
    private WebElement destination;

    @FindBy(id = "checkInDate")
    private WebElement checkInCalendar;

    @FindBy(xpath = "//table[@id='checkInDate_table']//div[@aria-label='" + TSMTask2Test.checkIn + "']")
    private WebElement checkInDate;

    @FindBy(id = "checkOutDate")
    private WebElement checkOutCalendar;

    @FindBy(xpath = "//table[@id='checkOutDate_table']//div[@aria-label='" + TSMTask2Test.checkOut + "']")
    private WebElement checkOutDate;

    @FindBy(id = "guestsDropdown")
    private WebElement guestsDropdown;

    @FindBy(xpath = "//select[@id='guestsDropdown']/option[contains(text(), '" + TSMTask2Test.guests + "')]")
    private WebElement guestsOptions;

    @FindBy(xpath = "//form[@name='hotelsEnquiryForm']//button[@type='submit']")
    private WebElement searchButton;

    public TSMHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void waitResultsUploadedHotelsDestination() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(uploadedHotelsDestination));
    }

    public TSMHomePage hotelSearch(String dest, String checkIn, String checkOut, String guests) {
        hotelsTab.click();
        hotelsDestination.clear();
        hotelsDestination.sendKeys(dest);
        waitResultsUploadedHotelsDestination();
        destination.click();
        checkInCalendar.sendKeys(checkIn);
        checkInDate.click();
        checkOutCalendar.sendKeys(checkOut);
        checkOutDate.click();
        guestsDropdown.sendKeys(guests);
        guestsOptions.click();
        searchButton.click();
        return new TSMHomePage(this.driver);
    }

}
