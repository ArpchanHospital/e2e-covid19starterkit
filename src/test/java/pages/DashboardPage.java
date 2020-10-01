package pages;

import framework.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends Wait {
    @FindBy(id = "bahmni.registration")
    private WebElement registration;

    @FindBy(id = "bahmni.programs")
    private WebElement programs;

    @FindBy(id = "overlay")
    public WebElement refresh;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public void gotoRegistration() {
        waitUntilElementInvisible(refresh);
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(registration));
        registration.click();
    }

    public void gotoPrograms() {
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(programs));
        programs.click();
    }
}