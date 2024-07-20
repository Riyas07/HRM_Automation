package WebElements;

import Services.DriverManager;
import Services.TestBase;
import org.example.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage  {
     private static LoginPage loginPage;
   private  WebDriverWait wait;
   private WebDriver driver;
    private LoginPage()
     {
         this.driver= DriverManager.getInstance().getDriver();
      wait=new WebDriverWait(driver, Duration.ofSeconds(30));
         driver.get(Util.getInstance().getBaseUrl());
     }
     public static LoginPage getInstance()
     {
          if (loginPage==null)
          {
               loginPage=new LoginPage();
               return loginPage;
          }
          else
          {
               return loginPage;
          }
     }
     public void Login_UnhappyPath()
     {
         WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-form-row'][1]//input")));
         if (username.isEnabled())
         {
             username.sendKeys("sam");
         }
         driver.findElement(By.xpath("//div[@class='oxd-form-row'][2]//input"));

         driver.findElement(By.xpath("//div[contains(@class,'oxd-form-actions orangehrm-login-action')]/button"))
                 .submit();
         String error_msg=    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'oxd-text oxd-text--p oxd-alert-content-text')]"))).getText();
        if (error_msg.equals("Invalid credentials"))
        {
            System.out.println("unhappy path completed");
        }
     }
     public void loginPage()
     {
          WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-form-row'][1]//input")));
          if (username.isEnabled())
          {
               username.sendKeys(Util.getInstance().getUsername());
          }
          WebElement password=driver.findElement(By.xpath("//div[@class='oxd-form-row'][2]//input"));
          if (password.isEnabled())
          {
               password.sendKeys(Util.getInstance().getPassword());
          }
          driver.findElement(By.xpath("//div[contains(@class,'oxd-form-actions orangehrm-login-action')]/button"))
                  .submit();
         String user=   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'userdropdown-name')]"))).getText();
        if (!user.isEmpty())
        {
            System.out.println("sucessfully logged");
        }

     }

}
