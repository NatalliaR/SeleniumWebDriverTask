package epam.com.tsm.SWDTask2.tests;

import epam.com.tsm.pages.TSMHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Natallia_Ramanchyk on 1/26/2016.
 */
public class BasicTest {
//    DesiredCapabilities capability = DesiredCapabilities.firefox();
    WebDriver driver;
   //public static final String URL = "https://www.travelsupermarket.com/";

    @BeforeMethod
    public void prepare() throws MalformedURLException {
  //      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(TSMHomePage.HP_URL);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
