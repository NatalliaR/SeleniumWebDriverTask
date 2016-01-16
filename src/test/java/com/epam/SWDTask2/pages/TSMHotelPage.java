package com.epam.SWDTask2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Natallia_Ramanchyk on 1/15/2016.
 */
public class TSMHotelPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='results-summary results-summary--has-map ng-scope results-summary--complete']")
    private WebElement uploadedHotelsResults;

    @FindBy(xpath = "//div[@class='results-list-wrapper results-list-desktop-layout']//h1")
    private WebElement title1;

    @FindBy(xpath = "//div[@class='results-list-wrapper results-list-desktop-layout']//h2")
    private WebElement title2;

    public TSMHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void waitResultsUploaded() {
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(uploadedHotelsResults));
    }

    public String verifyHotelsTitle1(){
        return title1.getText();
    }
    public String verifyHotelsTitle2(){
        return title2.getText();
    }

}
