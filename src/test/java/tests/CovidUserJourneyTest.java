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

        getVisitPage().gotoHome();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "clicked on home");

        getDashboardPage().gotoPrograms();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "navigated to programs");

        String patientId= getPatientSearchPage().selectPatient(firstName,lastName);
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "get current patient Id");

        getProgramEnrollmentPage().newProgramEnrollment();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "choose covid daily follow up form, enrolled and opened the covid 19 dashboard");

        getPatientDashboardPage().clickConsultation();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "clicked on consultation");

        getPatientConsultationPage().addNewObsForm();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "clicked on add new obs form and choose covid 19 follow up form");

        getPatientConsultationPage().fillCovidFormDetails();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "filled covid form details");

        getPatientConsultationPage().gotoPatientSearchPage();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "clicked on group icon");

        getVisitPage().gotoHome();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "clicked on home icon");

        getDashboardPage().gotoRegistration();
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "navigated to registration");

        getRegistrationPage().searchPatient(firstName + " " + lastName);
        getRegistrationPage().selectPatient(patientId);
        LoggerClass.showLog(CovidUserJourneyTest.class, Level.INFO, "searched and selected current patient");
    }
}