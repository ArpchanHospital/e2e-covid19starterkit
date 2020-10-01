package pages;

import framework.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PatientSearchPage extends Wait {
    @FindBy(css = ".active-patient .patient-name")
    private List<WebElement> patientNames;

    @FindBy(className = "patient-id")
    private List<WebElement> patientIds;

    @FindBy(css = ".active-patient .patient-name")
    private WebElement firstPatientName;

    @FindBy(css = ".active-patient")
    private List<WebElement> activePatients;

    @FindBy(id = "patientIdentifier")
    private WebElement searchPatientInPrograms;

    @FindBy(className = "patient-id")
    private WebElement firstPatientID;

    public PatientSearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void searchPatient(String firstName, String lastname) {
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(searchPatientInPrograms));
        searchPatientInPrograms.sendKeys(firstName + " " + lastname);
        searchPatientInPrograms.submit();
    }

    public String selectPatient(String firstName, String lastname) {
        waitUntilAllElementsVisible(firstPatientName);
        searchPatient(firstName, lastname);
        for (int i = 0; i < patientNames.size(); i++) {
            if (patientNames.get(i).getText().contains(firstName)) {
                waitUntilAllElementsVisible(firstPatientName);
                Wait.explicitWait(ExpectedConditions.elementToBeClickable(patientNames.get(i)));
                activePatients.get(i).click();
                waitUntilElementInvisible(framework.PageFactory.getDashboardPage().refresh);
            }
            return patientIds.get(i).getText();
        }
        return null;
    }
}