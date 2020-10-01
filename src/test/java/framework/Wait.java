package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class Wait extends Driver {
    public static void explicitWait(Function<WebDriver, WebElement> condition) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(condition);
    }

    public void waitUntilAllElementsVisible(WebElement elements) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitUntilElementInvisible(WebElement elements) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(elements));
    }
}