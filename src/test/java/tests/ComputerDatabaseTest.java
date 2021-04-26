package tests;

import clases.AddAComputerPage;
import clases.ComputerDatabaseHomePage;
import clases.EditComputerPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class ComputerDatabaseTest extends BaseTest {

    ComputerDatabaseHomePage computerDatabaseHomePage;
    AddAComputerPage addAComputerPage;
    EditComputerPage editComputerPage;

    @Parameters({"BROWSER","URL"})
    @BeforeMethod
    public void setup(String BROWSER, String URL) {
        init(URL,BROWSER);
    }
    @AfterMethod
    public void tearDown() {
        quit();
    }

    @Parameters({"computerName", "introducedDate", "discontinuedDate", "company", "failMessage"})
    @Test
    public void addANewComputerFailMessage(String computerName, String introducedDate, String discontinuedDate, String company, String failMessage) throws InterruptedException {
        computerDatabaseHomePage = new ComputerDatabaseHomePage(driver);
        addAComputerPage = new AddAComputerPage(driver);
        editComputerPage = new EditComputerPage(driver);

        computerDatabaseHomePage.addANewComputer();
        addAComputerPage.setComputerName(computerName);
        addAComputerPage.setIntroducedDate(introducedDate);
        addAComputerPage.setDiscontinuedDate(discontinuedDate);
        addAComputerPage.selectCompany(company);
        addAComputerPage.clickCreateThisComputer();

        computerDatabaseHomePage.assertFailMessage(failMessage);
    }
    @Parameters({"computerName", "introducedDate", "discontinuedDate", "company", "alertMessage"})
    @Test
    public void addANewComputerSuccess(String computerName, String introducedDate, String discontinuedDate, String company, String alertMessage) throws InterruptedException, IOException {
        computerDatabaseHomePage = new ComputerDatabaseHomePage(driver);
        addAComputerPage = new AddAComputerPage(driver);
        editComputerPage = new EditComputerPage(driver);

        computerDatabaseHomePage.addANewComputer();
        addAComputerPage.setComputerName(computerName);
        addAComputerPage.setIntroducedDate(introducedDate);
        addAComputerPage.setDiscontinuedDate(discontinuedDate);
        addAComputerPage.selectCompany(company);
        addAComputerPage.clickCreateThisComputer();

        computerDatabaseHomePage.assertAlertMessage(alertMessage);

        reportScreenShot("TestAllure","newComputerHaseBeenCreatedSuccessfully");
    }
    @Parameters({"computerNameToEdit", "computerName", "introducedDate", "discontinuedDate", "company", "alertMessage"})
    @Test
    public void editComputerSuccess(String computerNameToEdit, String computerName, String introducedDate, String discontinuedDate, String company, String alertMessage) throws InterruptedException {
        computerDatabaseHomePage = new ComputerDatabaseHomePage(driver);
        addAComputerPage = new AddAComputerPage(driver);
        editComputerPage = new EditComputerPage(driver);

        computerDatabaseHomePage.setSearchBox(computerNameToEdit);
        computerDatabaseHomePage.setFilterByName();
        computerDatabaseHomePage.clickComputerName(computerNameToEdit);

        addAComputerPage.setComputerName(computerName);
        addAComputerPage.setIntroducedDate(introducedDate);
        addAComputerPage.setDiscontinuedDate(discontinuedDate);
        addAComputerPage.selectCompany(company);
        editComputerPage.setSaveThisComputer();

        computerDatabaseHomePage.assertAlertMessage(alertMessage);
    }
    @Parameters({"computerNameToEdit", "computerName", "introducedDate", "discontinuedDate", "company", "failMessage"})
    @Test
    public void editComputerFailMessage(String computerNameToEdit, String computerName, String introducedDate, String discontinuedDate, String company, String failMessage) throws InterruptedException {
        computerDatabaseHomePage = new ComputerDatabaseHomePage(driver);
        addAComputerPage = new AddAComputerPage(driver);
        editComputerPage = new EditComputerPage(driver);

        computerDatabaseHomePage.setSearchBox(computerNameToEdit);
        computerDatabaseHomePage.setFilterByName();
        computerDatabaseHomePage.clickComputerName(computerNameToEdit);

        addAComputerPage.setComputerName(computerName);
        addAComputerPage.setIntroducedDate(introducedDate);
        addAComputerPage.setDiscontinuedDate(discontinuedDate);
        addAComputerPage.selectCompany(company);
        editComputerPage.setSaveThisComputer();

        computerDatabaseHomePage.assertFailMessage(failMessage);
    }

}