package epam.com.tsm.pages;

import epam.com.tsm.controls.DropdownList;
import epam.com.tsm.controls.EditField;
import epam.com.tsm.utils.Calendar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Natallia_Ramanchyk on 1/15/2016.
 */
public class TSMHomePage extends AbstractPage {

    public TSMHomePage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 3000);

    public static final String HP_URL = "https://www.travelsupermarket.com/";

    @FindBy(xpath = "//div[@class='site-logo']")
    private WebElement logo;

    @FindBy(id = "navigation-screen-toggle-area")
    private WebElement menu;

    @FindBy(id = "hero")
    private WebElement hero;

    @FindBy(tagName = "search-gadget")
    private WebElement searchGadget;

    @FindBy(xpath = "//button[@class='searchGadgetForm__channelOption ng-binding searchGadgetForm__channelOption--current'][contains(., 'Holidays')]")
    private WebElement holidaysTab;

    @FindBy(xpath = "//button[contains(., 'Flights')]")
    private WebElement flightsTab;

    @FindBy(xpath = "//button[contains(., 'Car Hire')]")
    private WebElement carHireTab;

    @FindBy(xpath = "//button[contains(., 'Insurance')]")
    private WebElement insuranceTab;

    @FindBy(xpath = "//button[contains(., 'Hotels')]")
    private WebElement hotelsTab;

    @FindBy(id = "hotelsDestinationField_input")
    private WebElement hotelsDestination;

    @FindBy(xpath = "//auto-complete[@id='hotelsDestinationField']/div/div")
    private WebElement autocompleteHotelsDestination;

    @FindBy(xpath = "//auto-complete[@id='hotelsDestinationField']//button")
    private List<WebElement> hotelsDestinationIn;

    @FindBy(id = "checkInDate")
    private WebElement checkInCalendar;

    @FindBy(xpath = "//table[@id='checkInDate_table']/tbody//div")
    private List<WebElement> checkInDates;

    @FindBy(xpath = "//div[@id='checkInDate_root']//div[@title='Next month']")
    private WebElement nextMonth;

    @FindBy(id = "checkOutDate")
    private WebElement checkOutCalendar;

    @FindBy(xpath = "//table[@id='checkOutDate_table']/tbody//div")
    private List <WebElement> checkOutDates;

    @FindBy(xpath = "//select[@id='room0_adults']")
    private WebElement guests;

    @FindBy(xpath = "//form[@name='hotelsEnquiryForm']//button[@type='submit']")
    private WebElement searchButton;

    public boolean isLogoPresented(){
        return logo.isDisplayed();
    }

    public boolean isMenuPresented(){
        return menu.isDisplayed();
    }

    public boolean isHeroPresented(){
        return hero.getText().contains("Welcome to our new home");
    }

    public boolean isSearchGadgetPresented(){
        return searchGadget.isDisplayed();
    }

    public boolean isHolidayTabPresented(){
        return holidaysTab.isDisplayed();
    }

    public boolean isFlightTabPresented(){
        return flightsTab.isDisplayed();
    }

    public boolean isHotelsTabPresented(){
        return hotelsTab.isDisplayed();
    }

    public boolean isCarHireTabPresented(){
        return carHireTab.isDisplayed();
    }

    public boolean isInsuranceTabPresented(){
        return insuranceTab.isDisplayed();
    }

    public TSMHomePage goToHotelsTab() {
        builder.click(hotelsTab).build().perform();
        return this;
    }

    public TSMHomePage editHotelDestination(String dest, String abbrDest) {
        EditField from = new EditField(hotelsDestination, autocompleteHotelsDestination, hotelsDestinationIn);
        from.selectAutocompleteValue(driver, dest, abbrDest);
        return this;
    }

    public TSMHomePage fillingHotelSearch(String checkIn, String checkOut, String guestsAmount) throws InterruptedException {
        Calendar fromDate = new Calendar(checkInCalendar, checkInDates, nextMonth);
        fromDate.selectDate(checkIn);
        Calendar toDate = new Calendar(checkOutCalendar, checkOutDates, nextMonth);
        toDate.selectDate(checkOut);
        DropdownList adultsList = new DropdownList(guests);
        adultsList.selectDropdownValue(guestsAmount);
        return new TSMHomePage(this.driver);
    }

    public TSMHomePage goToHotelSearch() {
        builder.click(searchButton).build().perform();
        return this;
    }
}
