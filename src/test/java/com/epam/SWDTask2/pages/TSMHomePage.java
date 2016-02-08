package com.epam.SWDTask2.pages;

import com.epam.SWDTask2.tests.TSMTask2Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Natallia_Ramanchyk on 1/15/2016.
 */
public class TSMHomePage extends AbstractPage {

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
        super(driver);
    }

 /*   public void waitResultsUploadedHotelsDestination() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(uploadedHotelsDestination));
    }*/

    public TSMHomePage goToHotelsTab() {
        builder.click(hotelsTab).build().perform();
        return this;
    }

    public TSMHomePage enterHotelDestination(String dest) {
        builder.sendKeys(hotelsDestination, dest).click(destination).build().perform();
        return this;
    }

    public TSMHomePage fillingHotelSearch(String checkIn, String checkOut, String guests) throws InterruptedException {
        checkInCalendar.sendKeys(checkIn);
        checkInDate.click();
        checkOutCalendar.sendKeys(checkOut);
        checkOutDate.click();
        guestsDropdown.sendKeys(guests);
        guestsOptions.click();
        return new TSMHomePage(this.driver);
    }

    public TSMHomePage goToHotelSearch() {
        builder.click(searchButton).build().perform();
        return this;
    }
}
