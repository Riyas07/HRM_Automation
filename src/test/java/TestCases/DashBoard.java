package TestCases;

import Services.TestBase;
import WebElements.DashBoard_Page;
import WebElements.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class DashBoard extends TestBase {
    @Test
    @Parameters("username")
    public void Login(String username){
        LoginPage.getInstance().loginPage();
        System.out.println(username);
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
