package tests;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;
    String screenshotPath = "src/test/screenshots/";
    String extension = ".png";

    public void init(String URL, String BROWSER) {
        driverManager = DriverManagerFactory.getDriverManager(BROWSER);
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    public void quit() {
        driverManager.quitWebDriver();
    }

    public void takeScreenShot(String fileName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(screenshotPath + fileName + extension));

    }

    public void reportScreenShot(String screenShotName, String description) throws IOException {
        takeScreenShot(screenShotName);
        Path content = Paths.get(screenshotPath + screenShotName + extension);
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment(description, is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}