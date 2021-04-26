package clases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditComputerPage extends BasePageActions {
    WebDriver driver;

    public EditComputerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.danger")
    WebElement deleteThisComputerButton;
    @FindBy(css = ".btn.primary")
    WebElement saveThisComputerButton;

    public void setDeleteThisComputerButton() {
        clickElement(deleteThisComputerButton);
    }

    public void setSaveThisComputer() {
        clickElement(saveThisComputerButton);
    }



}