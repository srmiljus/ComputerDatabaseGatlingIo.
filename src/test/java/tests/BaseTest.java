package tests;

import org.openqa.selenium.WebDriver;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;

    public void init(String URL, String BROWSER) {
        driverManager = DriverManagerFactory.getDriverManager(BROWSER);
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    public void quit() {
        driverManager.quitWebDriver();
    }

}
