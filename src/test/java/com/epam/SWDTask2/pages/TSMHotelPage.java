package com.epam.SWDTask2.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

/**
 * Created by Natallia_Ramanchyk on 1/15/2016.
 */
public class TSMHotelPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='results-summary results-summary--has-map ng-scope results-summary--complete']")
    private WebElement uploadedHotelsResults;

    @FindBy(xpath = "//*[@class='results-list-wrapper results-list-desktop-layout']//h1")
    public WebElement whereHotelsTitle;

    @FindBy(xpath = "//*[@class='results-list-wrapper results-list-desktop-layout']//h2")
    private WebElement durationFromToTitle;

    public TSMHotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    /*   public TSMHotelPage highlightElement(WebDriver driver, WebElement element) throws InterruptedException {
           String bg = element.getCssValue("backgroundColor");
           JavascriptExecutor js = ((JavascriptExecutor) driver);
           js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
           sleep(2000);
           takeScreenshot(driver);
           return this;
           js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
       }*/ //*[contains(@class,'значение')]



    public void waitResultsUploaded() {
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(uploadedHotelsResults));
    }
    public WebElement getTitleWhereHotels() {
        return whereHotelsTitle;
    }

    public String textWhereHotelsFromTitle() {
        return whereHotelsTitle.getText();
    }
    public WebElement getTitleDurationFromTo() {
        return durationFromToTitle;
    }

    public String textDurationFromToFromTitle() {
        return durationFromToTitle.getText();
    }

}
