package framework;

import pages.*;

public class PageFactory extends Wait {
    private static LoginPage loginPage;

    public static LoginPage getLoginPage() {
        return loginPage;
    }

    public static void instantiatePages() {
        loginPage = new LoginPage();
    }
}