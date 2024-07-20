package Services;

import Services.BrowserManager;
import Services.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase
{
    public WebDriver driver;

    @BeforeTest
  public void base()
  {
      BrowserManager.getInstance().setBrowser();
     this.driver= DriverManager.getInstance().getDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }
  //@AfterTest
  public void end()
  {
      DriverManager.getInstance().quitDriver();
  }
}
