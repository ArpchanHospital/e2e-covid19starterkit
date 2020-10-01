package tests;

import framework.BaseTestClass;
import framework.LoggerClass;
import org.apache.log4j.Level;
import org.testng.annotations.Test;

public class CovidUserJourneyTest extends BaseTestClass {
    @Test
    public void testCovidUserJourney() {
        getLoginPage().login();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "logged in");
    }
}