package pages;

import framework.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PatientDetailsPage extends Wait {
    @FindBy(id = "givenName")
    private WebElement firstname;

    @FindBy(id = "familyName")
    private WebElement lastname;

    @FindBy(id = "gender")
    private WebElement gender;

    @FindBy(id = "ageYears")
    private WebElement age;

    @FindBy(id = "cityVillage")
    private WebElement village;

    @FindBy(css = ".toggle-button")
    private WebElement visitDropdown;

    @FindBy(className = "buttonClass")
    private List<WebElement> emergencyVisit;

    @FindBy(css = ".submit-btn")
    private WebElement save;

    @FindBy(css = ".right.confirm")
    private WebElement enterVisitDetails;

    public PatientDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public void fillPatientDetails(String firstName, String lastName) {
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(firstname));
        firstname.clear();
        firstname.sendKeys(firstName);
        lastname.clear();
        lastname.sendKeys(lastName);
        selectGender();
        age.clear();
        age.sendKeys("21");
        village.sendKeys("bahamas");
        visitDropdown.click();
        emergencyVisit.get(1).click();
    }

    private void selectGender() {
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(gender));
        Select Gender = new Select(gender);
        Gender.selectByVisibleText("Female");
    }

    public void clickEnterVisitDetails() {
        waitUntilElementInvisible(framework.PageFactory.getDashboardPage().refresh);
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(enterVisitDetails));
        enterVisitDetails.click();
    }
}