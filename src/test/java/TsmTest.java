import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

/**
 * Created by Natallia_Ramanchyk on 1/12/2016.
 */
public class TsmTest {

    @Test
    public void travelSupermarketHomePageTest() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.travelsupermarket.com/");
        WebElement logo = driver.findElement(By.xpath("//div[@class='site-logo']"));
        WebElement menu = driver.findElement(By.id("navigation-screen-toggle-area"));
        WebElement holidaysTab = driver.findElement(By.xpath("//button[@class='searchGadgetForm__channelOption ng-binding searchGadgetForm__channelOption--current']"));
        WebElement flightTab = driver.findElement(By.xpath("//button[contains(., 'Flights')]"));
        WebElement hotelsTab = driver.findElement(By.xpath("//button[contains(., 'Hotels')]"));
        WebElement carHireTab = driver.findElement(By.xpath("//button[contains(., 'Car Hire')]"));
        WebElement insuranceTab = driver.findElement(By.xpath("//button[contains(., 'Insurance')]"));
        WebElement searchGadget = driver.findElement(By.tagName("search-gadget"));

        assertTrue(logo.isDisplayed());
        assertTrue(menu.isDisplayed());
        assertTrue(holidaysTab.isDisplayed());
        assertTrue(flightTab.isDisplayed());
        assertTrue(hotelsTab.isDisplayed());
        assertTrue(carHireTab.isDisplayed());
        assertTrue(insuranceTab.isDisplayed());
        assertTrue(searchGadget.isDisplayed());

        driver.close();
        driver.quit();
    }


    @Test
    public void testHotelsSearch() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.travelsupermarket.com/");
        WebDriverWait wait = new WebDriverWait(driver, 3000);

        String dest = "528cbf04e4b0ec1df5083fbc";
        String destTest = "Dubai";
        String checkIn = "20 Jan 16";
        String checkOut = "27 Jan 16";
        String checkInTest = "20th Jan";
        String checkOutTest = "27th Jan";
        String guests = "2 adults in 1 room";

        WebElement hotelsTab = driver.findElement(By.xpath("//button[contains(., 'Hotels')]"));
        hotelsTab.click();

        WebElement hotelsDestination = driver.findElement(By.id("hotelsDestinationField_input"));
        hotelsDestination.clear();
        hotelsDestination.sendKeys("dub");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//auto-complete[@id='hotelsDestinationField']/div/div")));

        WebElement destination = driver.findElement(By.xpath("//button[@focus-on='" + dest + "']"));
        destination.click();

        WebElement checkInCalendar = driver.findElement(By.id("checkInDate"));
        checkInCalendar.click();
        WebElement checkInDate = driver.findElement(By.xpath("//table[@id='checkInDate_table']//div[@aria-label='" + checkIn + "']"));
        checkInDate.click();

        WebElement checkOutCalendar = driver.findElement(By.id("checkOutDate"));
        checkOutCalendar.click();
        WebElement checkOutDate = driver.findElement(By.xpath("//table[@id='checkOutDate_table']//div[@aria-label='" + checkOut + "']"));
        checkOutDate.click();

        WebElement guestsOptions = driver.findElement(By.xpath("//select[@id='guestsDropdown']/option[contains(text(), '" + guests + "')]"));
        guestsOptions.click();

        WebElement searchButton = driver.findElement(By.xpath("//form[@name='hotelsEnquiryForm']//button[@type='submit']"));
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='results-summary results-summary--has-map ng-scope results-summary--complete']")));

        WebElement title1 = driver.findElement(By.xpath("//div[@class='results-list-wrapper results-list-desktop-layout']//h1"));
        assertEquals(title1.getText(), destTest);

        WebElement title2 = driver.findElement(By.xpath("//div[@class='results-list-wrapper results-list-desktop-layout']//h2"));
        assertEquals(title2.getText(), checkInTest + " to " + checkOutTest + " - Change search");

        driver.close();
        driver.quit();
    }
}
