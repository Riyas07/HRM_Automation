package Services;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();
    private static DriverManager manager;
    private DriverManager ()
    {

    }
    public static DriverManager getInstance()
    {
        if (manager==null)
        {
            manager=new DriverManager();
            return manager;
        }
        else {
            return manager;
        }
    }
    public void setDriver(WebDriver driver)
    {
        this.threadLocal.set(driver);
    }
    public WebDriver getDriver()
    {
        return this.threadLocal.get();
    }
    public void quitDriver()
    {
        this.threadLocal.get().quit();
    }
}
