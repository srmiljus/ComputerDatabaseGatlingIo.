package clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerDatabaseHomePage extends BasePageActions {
    WebDriver driver;

    public ComputerDatabaseHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchbox")
    WebElement searchBox;
    @FindBy(id = "searchsubmit")
    WebElement filterByName;
    @FindBy(xpath = "//a[text()='Add a new computer']")
    WebElement addANewComputer;
    @FindBy(xpath = "//div[@class='clearfix error']//span[@class='help-inline']")
    WebElement failMessage;
    @FindBy(xpath = "//a[text()='Displaying 1 to 10 of 574']/../..//li[2]")
    WebElement responseMessage;
    @FindBy(css = ".alert-message.warning")
    WebElement alertMessage;

    public void setSearchBox(String computerName) throws InterruptedException {
        typeText(searchBox, computerName);
    }

    public void setFilterByName() {
        clickElement(filterByName);
    }

    public void addANewComputer() {
        clickElement(addANewComputer);
    }

    public void clickComputerName(String computerName) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='" + computerName + "']")).click();
    }

    public void assertFailMessage(String failMessageText) {
        assertText(failMessage, failMessageText);
    }

    public void assertResponseMessage(String responseMessageText) {
        assertText(responseMessage, responseMessageText);
    }

    public void assertAlertMessage(String alertMessageText) {
        assertText(alertMessage, alertMessageText);
    }


}