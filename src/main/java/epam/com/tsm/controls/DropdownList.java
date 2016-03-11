package epam.com.tsm.controls;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Natallia_Ramanchyk on 3/11/2016.
 */
public class DropdownList {
    private WebElement list;

    public DropdownList(WebElement list){
        this.list = list;
    }

    public void selectDropdownValue(String valueToSelect){
        new Select(list).selectByValue(valueToSelect);
    }
}
