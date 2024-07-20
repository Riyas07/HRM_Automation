package TestCases;

import Services.TestBase;
import WebElements.DashBoard_Page;
import WebElements.LoginPage;
import org.testng.annotations.Test;

public class DashBoard extends TestBase {
    @Test
    public void Login(){
        LoginPage.getInstance().loginPage();
    }
    @Test(dependsOnMethods = "Login")
    public void navaligateToDashboard()
    {
        DashBoard_Page.getInstance().navigateToTimeSheetPage();

    }
    @Test(dependsOnMethods = "navaligateToDashboard")
    public void validate_timsheet()
    {
        DashBoard_Page.getInstance().validate_timeSheet("2024-07-18T08:00:00");
    }
}
