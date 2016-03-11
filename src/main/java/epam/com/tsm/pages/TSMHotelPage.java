package epam.com.tsm.pages;

import epam.com.tsm.controls.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void waitResultsUploaded(){
        Wait waitResults = new Wait(driver, uploadedHotelsResults);
        waitResults.waitElementIsPresent();
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
