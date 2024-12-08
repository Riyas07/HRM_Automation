package WebElements;

import Services.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashBoard_Page {
    private static DashBoard_Page dashBoardPage;
    private WebDriver driver;
    private WebDriverWait wait;
    private DashBoard_Page()
    {
      driver= DriverManager.getInstance().getDriver();
      wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public static DashBoard_Page getInstance()
    {
        if (dashBoardPage==null)
        {
            dashBoardPage=new DashBoard_Page();
            return dashBoardPage;
        }
        else {
            return dashBoardPage;
        }
    }
    public void navigateToTimeSheetPage()
    {
        WebElement timeSheet_btn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-layout-container')]//div[@class='orangehrm-attendance-card-bar']/button")));
        timeSheet_btn
                .click();

    }
   public void validate_timeSheet(LocalDateTime localDateTime) {

       WebElement calender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-date-input']/input")));
       JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
       javascriptExecutor.executeScript("arguments[0].click();", calender);
       WebElement yearSelector = driver.findElement(By.xpath("//ul[contains(@class,'oxd-calendar-selector')]/li[2]"));
       yearSelector.click();

 //       DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//       LocalDateTime localDateTime=LocalDateTime.parse(dateTime,formatter);
      WebElement year= driver.findElement(By.xpath("//ul[contains(@class,'oxd-calendar-dropdown')]//li[text()='"+localDateTime.getYear()+"']"));
      year.click();
     WebElement month_click=driver.findElement(By.xpath("//ul[contains(@class,'oxd-calendar-selector')]/li[1]"));
     month_click.click();
     WebElement selectMonth=driver.findElement(By.xpath("//ul[contains(@class,'oxd-calendar-dropdown')]/li[text()='"+localDateTime.getMonth().toString().substring(0,1).toUpperCase()+localDateTime.getMonth().toString().substring(1).toLowerCase()+"']"));
       selectMonth.click();
       driver.findElement(By.xpath("//div[contains(@class,'oxd-calendar-header')]//button[1]")).click();
       driver.findElement(By.xpath("//div[contains(@class,'oxd-calendar-header')]//button[2]")).click();
       driver.findElement(By.xpath("//div[contains(@class,'oxd-calendar-dates-grid')]//div[text()='"+localDateTime.getDayOfMonth()+"']"))
               .click();

       driver.findElement(By.xpath("//div[contains(@class,'oxd-form')][2]//textarea")).sendKeys("riyas punch in and puch out");
       driver.findElement(By.xpath("//div[contains(@class,'oxd-form-actions')]//button"))
               .click();
       String success=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='oxd-toaster_1']//p[1]"))).getText();
       String success2=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='oxd-toaster_1']//p[2]"))).getText();
     if (success.equals("Success")   && success2.equals("Successfully Saved"))
     {
         System.out.println("you successfully puched in");
     }
   }
}
