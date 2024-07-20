package Services;

import org.example.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserManager {
    private static BrowserManager manager;
    private BrowserManager()
    {

    }
    public static BrowserManager getInstance()
    {
        if (manager==null)
        {
            manager=new BrowserManager();
            return manager;
        }
        else
        {
            return manager;
        }
    }
    public void setBrowser()
    {
        if (Util.getInstance().getBrowser().equalsIgnoreCase("chrome"))
        {
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--start-maximized");
            options.setAcceptInsecureCerts(true);
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-extensions");
            WebDriver driver=new ChromeDriver(options);
            DriverManager.getInstance().setDriver(driver);
        }
        else if (Util.getInstance().getBrowser().equalsIgnoreCase("edge"))
        {
            EdgeOptions options=new EdgeOptions();
            // General Performance Enhancements
            //options.addArguments("--headless"); // Run Edge in headless mode
           //  options.addArguments("--disable-gpu"); // Disable GPU hardware acceleration
            options.addArguments("--no-sandbox"); // Disable sandbox security feature
            options.addArguments("--disable-dev-shm-usage"); // Overcome resource limits in Docker
            options.addArguments("--disable-extensions"); // Disable extensions
            options.addArguments("--disable-popup-blocking"); // Disable popup blocking
            options.addArguments("--disable-notifications"); // Disable web notifications
            options.addArguments("--enable-automation"); // Mark the browser as being controlled by automation
            options.setAcceptInsecureCerts(true);
            // Memory and Resource Management
            options.addArguments("--aggressive-cache-discard"); // Aggressively discard cache
            options.addArguments("--disable-application-cache"); // Disable application cache
            options.addArguments("--disk-cache-size=0"); // Set disk cache size to zero
            options.addArguments("--media-cache-size=0"); // Set media cache size to zero

            // Customization
            options.addArguments("--start-maximized"); // Open Edge in maximized mode

            WebDriver driver=new EdgeDriver(options);
            DriverManager.getInstance().setDriver(driver);
        }
    }
}
