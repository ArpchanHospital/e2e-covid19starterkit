package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    protected static WebDriver driver;

    public static WebDriver getInstanceOfDriver() {
        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver getInstanceOfHeadLessDriver() {
        FirefoxOptions option = new FirefoxOptions();
        option.setHeadless(true);
        driver = new FirefoxDriver(option);
        return driver;
    }
}