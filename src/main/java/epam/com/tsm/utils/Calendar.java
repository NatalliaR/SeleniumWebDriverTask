package epam.com.tsm.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

/**
 * Created by Natallia_Ramanchyk on 3/11/2016.
 */
public class Calendar {
    private WebElement calendar;
    private List<WebElement> calendarDates;
    private WebElement nextLink;

    public Calendar(WebElement calendar, List<WebElement> calendarDates, WebElement nextLink){
        this.calendar = calendar;
        this.calendarDates = calendarDates;
        this.nextLink = nextLink;
    }

    public void selectDate(String date){
        calendar.click();
        findDate(date);
    }

    private void findDate(String date){
        for (int i = 0; i < calendarDates.size(); i++) {
            if (calendarDates.get(i).getAttribute("aria-label").equals(date)){
                calendarDates.get(i).click();
                return;
            }
        }
        if (nextLink.getAttribute("class").equals("picker__nav--next picker__nav--disabled")){
            fail("You can't book the ticket for specified date!");
        }
        else{
            nextLink.click();
            findDate(date);
        }
    }
}
