package tests;

import framework.BaseTestClass;
import framework.LoggerClass;
import org.apache.log4j.Level;
import org.testng.annotations.Test;

import java.util.Random;

public class CovidUserJourneyTest extends BaseTestClass {
    Random random = new Random();
    char nextRandomChar = (char) (65 + (int) (random.nextFloat() * (90 - 65 + 1)));
    public String firstName = "covid" + nextRandomChar;
    public String lastName = "patient" + nextRandomChar;

    @Test
    public void testCovidUserJourney() {
        getLoginPage().login();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "logged in");

        getDashboardPage().gotoRegistration();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "clicked on registration");

        getRegistrationPage().clickCreateNew();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "clicked on createNew");

        getPatientDetailsPage().fillPatientDetails(firstName, lastName);
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "filled patient details and started emergency visit");
    }
}