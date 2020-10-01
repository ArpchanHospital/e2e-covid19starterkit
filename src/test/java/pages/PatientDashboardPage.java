package pages;

import framework.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PatientDashboardPage extends Wait {
    @FindBy(css = ".btn--left")
    private WebElement consultation;

    public PatientDashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickConsultation() {
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(consultation));
        consultation.click();
    }
}