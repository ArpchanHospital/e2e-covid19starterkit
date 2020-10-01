package pages;

import framework.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PatientConsultationPage extends Wait {
    @FindBy(id = "template-control-panel-button")
    private WebElement addNewObsForm;

    @FindBy(id = "COVID-19_Daily_Follow_Up_IPD")
    private WebElement covidDailyFollowUpForm;

    @FindBy(xpath = "//*[contains(text(),\"Fever\")]")
    private WebElement feverButton;

    @FindBy(xpath = "//*[contains(text(),\"Cough\")]")
    private WebElement coughButton;

    @FindBy(className = "confirm")
    private WebElement saveForm;

    @FindBy(id = "patients-link")
    private WebElement gotoPatientsSearchPage;

    public PatientConsultationPage() {
        PageFactory.initElements(driver, this);
    }

    public void addNewObsForm() {
        waitUntilElementInvisible(framework.PageFactory.getDashboardPage().refresh);
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(addNewObsForm));
        addNewObsForm.click();
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(covidDailyFollowUpForm));
        covidDailyFollowUpForm.click();
    }

    public void fillCovidFormDetails() {
        waitUntilElementInvisible(framework.PageFactory.getDashboardPage().refresh);
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(feverButton));
        feverButton.click();
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(coughButton));
        coughButton.click();
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(saveForm));
        saveForm.click();
        waitUntilElementInvisible(framework.PageFactory.getDashboardPage().refresh);
    }

    public void gotoPatientSearchPage() {
        Wait.explicitWait(ExpectedConditions.visibilityOf(gotoPatientsSearchPage));
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(gotoPatientsSearchPage));
        gotoPatientsSearchPage.click();
    }
}