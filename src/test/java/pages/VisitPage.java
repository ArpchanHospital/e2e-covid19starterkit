package pages;

import framework.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VisitPage extends Wait {

    @FindBy(className = "cancel")
    private WebElement closeVisit;

    @FindBy(css = ".fa.fa-home")
    private WebElement home;

    public VisitPage() {
        PageFactory.initElements(driver, this);
    }

    public void gotoHome() {
        waitUntilElementInvisible(framework.PageFactory.getDashboardPage().refresh);
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(home));
        home.click();
    }

    public void closeVisit() {
        waitUntilElementInvisible(framework.PageFactory.getDashboardPage().refresh);
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(closeVisit));
        closeVisit.click();
    }
}