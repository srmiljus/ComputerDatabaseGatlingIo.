package clases;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePageActions {
    WebDriver driver;
    final static int WAIT_TIME = Integer.parseInt(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT_TIME"));

    public BasePageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
            element.click();
        } catch (StaleElementReferenceException e) {
            element.click();
        }
    }

    public void typeText(WebElement element, String text) throws InterruptedException {
        Thread.sleep(1000);
        if (text != null) {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
        } else {
            element.clear();
        }
    }

    public void selectByVisibleText(WebElement element, String text) {
        if (text != null) {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Select select = new Select(element);
            select.selectByVisibleText(text);
        }
    }

    public void assertText(WebElement element, String text) {
        Assert.assertEquals(element.getText(), text);
    }
}