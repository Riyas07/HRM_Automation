package Services;

import Services.BrowserManager;
import Services.DriverManager;
import org.openqa.selenium.By;
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
  @AfterTest
  public void end()
  {
      driver.findElement(By.xpath("//ul//li//img//ancestor::ul")).click();
      driver.findElement(By.xpath("//ul//li//img//parent::span//following-sibling::ul//li[4]"))
                      .click();
      DriverManager.getInstance().quitDriver();
  }
}
