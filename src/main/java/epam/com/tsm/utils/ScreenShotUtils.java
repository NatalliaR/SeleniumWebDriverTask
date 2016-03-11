package epam.com.tsm.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by Natallia_Ramanchyk on 1/27/2016.
 */
public class ScreenShotUtils {
    public static void takeScreenShot(WebDriver driver) {
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFileToDirectory(screen, new File("screenshots"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenShotWithHighlightElement(WebElement element, WebDriver driver){
        String background = element.getCssValue("backgroundColor");
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = 'yellow'", element);
        takeScreenShot(driver);
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + background + "'", element);
    }
}
