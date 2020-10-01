package pages;

import framework.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProgramEnrollmentPage extends Wait {
    @FindBy(css = ".section-title")
    private WebElement newProgramEnrollment;

    @FindBy(css = "select[ng-model='programSelected']")
    private WebElement chooseProgram;

    @FindBy(css = "input.ng-valid-max")
    private WebElement startDate;

    @FindBy(id = "ID_Number")
    private WebElement idNumber;

    @FindBy(css = "input[value=\"Enroll\"]")
    private WebElement enroll;

    @FindBy(className = "proggram-dashboard-text")
    private WebElement covidProgramDashboard;

    @FindBy(css = "input[type='date']")
    private WebElement date;

    public ProgramEnrollmentPage() {
        PageFactory.initElements(driver, this);
    }

    public void newProgramEnrollment() {
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(newProgramEnrollment));
        newProgramEnrollment.click();
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(startDate));
        selectProgram();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].type = arguments[1]", startDate, "text");
        js.executeScript("arguments[0].value = arguments[1]", startDate, "01/10/2020");
        idNumber.sendKeys("" + System.currentTimeMillis());
        enroll.click();
        Wait.explicitWait(ExpectedConditions.visibilityOf(covidProgramDashboard));
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(covidProgramDashboard));
        covidProgramDashboard.click();
    }

    private void selectProgram() {
        Select program = new Select(chooseProgram);
        program.selectByVisibleText("COVID-19 Program");
    }
}