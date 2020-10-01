package pages;

import framework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static framework.PageFactory.getDashboardPage;

public class RegistrationPage extends Wait {
    @FindBy(css = ".fa-plus")
    private WebElement createNewPatient;

    @FindBy(id = "name")
    private WebElement name;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNew() {
        waitUntilElementInvisible(getDashboardPage().refresh);
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(createNewPatient));
        createNewPatient.click();
    }

    public void searchPatient(String firstName) {
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(name));
        name.sendKeys(firstName);
        name.submit();
    }

    public void selectPatient(String patientId) {
        waitUntilElementInvisible(getDashboardPage().refresh);
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(By.linkText(patientId)));
        driver.findElement(By.linkText(patientId)).click();
    }
}