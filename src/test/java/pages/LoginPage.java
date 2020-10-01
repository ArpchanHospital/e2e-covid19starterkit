package pages;

import framework.ConfigureProperties;
import framework.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends Wait {
    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "location")
    private WebElement location;

    @FindBy(className = "confirm")
    private WebElement login;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void login() {
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(login));
        username.clear();
        username.sendKeys(ConfigureProperties.adminUsername);
        password.clear();
        password.sendKeys(ConfigureProperties.adminPassword);
        selectLocation();
        login.click();
    }

    private void selectLocation() {
        Select lcn = new Select(location);
        lcn.selectByVisibleText("General Ward");
    }
}