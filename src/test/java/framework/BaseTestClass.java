package framework;

import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static framework.ConfigureProperties.*;

public class BaseTestClass extends PageFactory {
    WebDriver baseDriver;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        try {
            baseDriver = Driver.getInstanceOfDriver();
            LoggerClass.showLog(BaseTestClass.class, Level.INFO, "firefox driver initialised");

            baseDriver.manage().window().maximize();

            PageFactory.instantiatePages();
            LoggerClass.showLog(BaseTestClass.class, Level.INFO, "pages instantiated");

            readProperties();
            LoggerClass.showLog(BaseTestClass.class, Level.INFO, "read config properties");

            setUrlToDriver();
            LoggerClass.showLog(BaseTestClass.class, Level.INFO, "URL set to" + " driver");
        } catch (Exception e) {
            LoggerClass.showLog(BaseTestClass.class, Level.WARN, "Exception: " + e.getMessage());
        }
    }

    private void setUrlToDriver() {
        baseDriver.get(localURL);
        LoggerClass.showLog(BaseTestClass.class, Level.INFO, "Configured url to driver");
    }

    @AfterMethod
    public void screenshot(ITestResult result) {
        String screenshotName = "Screenshot " + result.getMethod().getMethodName() + " " + java.util.Calendar.getInstance().getTime();
        try {
            if (ITestResult.FAILURE == result.getStatus()) {
                TakeSnapShot.captureScreenshot(screenshotName);
                LoggerClass.showLog(BaseTestClass.class, Level.INFO, "captured Screenshot");
            }
        } catch (Exception e) {
            LoggerClass.showLog(BaseTestClass.class, Level.WARN, "Exception: " + e.getMessage());
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        baseDriver.quit();
        LoggerClass.showLog(BaseTestClass.class, Level.INFO, "firefox driver quit");
    }
}