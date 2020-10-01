package framework;

import pages.*;

public class PageFactory extends Wait {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static RegistrationPage registrationPage;
    private static PatientDetailsPage patientDetailsPage;

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

    public static void instantiatePages() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        registrationPage = new RegistrationPage();
        patientDetailsPage = new PatientDetailsPage();
    }
}