package com.epam.SWDTask2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Natallia_Ramanchyk on 1/26/2016.
 */
public abstract class AbstractPage {
    protected WebDriver driver;
    protected Actions builder;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        this.builder = new Actions(driver);
        PageFactory.initElements(this.driver, this);
    }

}
