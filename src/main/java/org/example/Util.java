package org.example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    private static Util util;
    private Properties properties;
private Util ()
{
    try
    {
        InputStream inputStream=new FileInputStream("src/main/resources/config.properties");
        properties=new Properties();
        properties.load(inputStream);
    }
    catch (Exception e)
    {
        System.out.println(e.getStackTrace());
    }
}
public static Util getInstance()
{
    if (util==null)
    {
        util=new Util();
        return util;
    }
    else
    {
        return util;
    }
}
public String getBrowser()
{
    return this.properties.getProperty("browser");
}
public String getBaseUrl()
{
    return this.properties.getProperty("Hrm_login_url");
}
public String getUsername()
{
    return this.properties.getProperty("username");
}
public String getPassword()
{
    return this.properties.getProperty("password");
}
}
