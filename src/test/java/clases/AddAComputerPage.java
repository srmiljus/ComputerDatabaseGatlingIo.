package clases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAComputerPage extends BasePageActions{
    WebDriver driver;

    public AddAComputerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    WebElement computerName;
    @FindBy(xpath = "//label[text()='Introduced']/.././/input")
    WebElement introducedDate;
    @FindBy(xpath = "//label[text()='Discontinued']/.././/input")
    WebElement discontinuedDate;
    @FindBy(xpath = "//label[text()='Company']/.././/select")
    WebElement company;
    @FindBy(css = ".btn.primary")
    WebElement createThisComputer;
    @FindBy(xpath = "//a[text()='Cancel']")
    WebElement cancelButton;

    public void setComputerName(String name) throws InterruptedException {
        typeText(computerName,name);
    }

    public void setIntroducedDate(String date) throws InterruptedException {
        typeText(introducedDate,date);
    }

    public void setDiscontinuedDate(String date) throws InterruptedException {
        typeText(discontinuedDate,date);
    }

    public void selectCompany(String companyText) {
        selectByVisibleText(company,companyText);
    }

    public void clickCreateThisComputer() {
        clickElement(createThisComputer);
    }

    public void setCancelButton() {
        clickElement(cancelButton);
    }

}


