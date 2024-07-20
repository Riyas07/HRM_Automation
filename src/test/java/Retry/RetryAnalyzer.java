package Retry;

import Services.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count=0;
    int limit=3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!(iTestResult.isSuccess()))
        {
            if (count<limit)
            {
                TakesScreenshot screenshot=(TakesScreenshot) DriverManager.getInstance().getDriver();
                File scr= screenshot.getScreenshotAs(OutputType.FILE);
                File to =new File("ScreenShots/error.png");
                try {
                    FileHandler.copy(scr,to);
                } catch (IOException e) {
                    System.out.println(e.fillInStackTrace());
                }
                count++;
                return true;
            }

        }
        return false;
    }
}
