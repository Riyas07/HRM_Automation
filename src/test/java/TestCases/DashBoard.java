package TestCases;

import Services.TestBase;
import WebElements.DashBoard_Page;
import WebElements.LoginPage;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

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
        DashBoard_Page.getInstance().validate_timeSheet(LocalDateTime.now());
    }
}
