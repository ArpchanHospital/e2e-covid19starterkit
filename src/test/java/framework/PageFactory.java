package framework;

import pages.*;

public class PageFactory extends Wait {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static RegistrationPage registrationPage;

    public static LoginPage getLoginPage() {
        return loginPage;
    }

    public static DashboardPage getDashboardPage() {
        return dashboardPage;
    }

    public static RegistrationPage getRegistrationPage() {
        return registrationPage;
    }

    public static void instantiatePages() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        registrationPage = new RegistrationPage();
    }
}