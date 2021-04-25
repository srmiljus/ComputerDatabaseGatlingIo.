package selenium_core;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
    protected void createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver_86.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        this.driver = new FirefoxDriver(options );
    }

}
