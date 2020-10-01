package framework;

import pages.*;

public class PageFactory extends Wait {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static RegistrationPage registrationPage;
    private static PatientDetailsPage patientDetailsPage;
    private static VisitPage visitPage;
    private static PatientSearchPage patientSearchPage;
    private static ProgramEnrollmentPage programEnrollmentPage;

    public static LoginPage getLoginPage() {
        return loginPage;
    }

    public static DashboardPage getDashboardPage() {
        return dashboardPage;
    }

    public static RegistrationPage getRegistrationPage() {
        return registrationPage;
    }

    public static PatientDetailsPage getPatientDetailsPage() {
        return patientDetailsPage;
    }
    public static VisitPage getVisitPage() {
        return visitPage;
    }

    public static PatientSearchPage getPatientSearchPage() {
        return patientSearchPage;
    }

    public static ProgramEnrollmentPage getProgramEnrollmentPage() {
        return programEnrollmentPage;
    }

    public static void instantiatePages() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        registrationPage = new RegistrationPage();
        patientDetailsPage = new PatientDetailsPage();
        visitPage = new VisitPage();
        patientSearchPage = new PatientSearchPage();
        programEnrollmentPage = new ProgramEnrollmentPage();
    }
}