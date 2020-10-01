package framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class TakeSnapShot extends Driver {
    private static final String filepath = "test-output/ScreenShots/";

    public static void captureScreenshot(String screenshotName) throws Exception {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filepath + screenshotName + ".jpg");
        FileUtils.copyFile(srcFile, destFile);
    }
}