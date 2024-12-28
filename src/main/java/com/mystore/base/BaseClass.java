package com.mystore.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static Properties prop;
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeTest
    public void loadConfig() throws IOException {
        try {
            prop = new Properties();
            System.out.println("super constructor invoked");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\configuration\\config.properties");
            prop.load(ip);
            System.out.println("driver" + driver);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void launchWeb(){

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver.set(new InternetExplorerDriver());
        }

        //Maximize the screen
        getDriver().manage().window().maximize();
        //Delete all the cookies
        getDriver().manage().deleteAllCookies();
        //Implicit TimeOuts
        getDriver().manage().timeouts().implicitlyWait
                (Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        //PageLoad TimeOuts
        getDriver().manage().timeouts().pageLoadTimeout
                (Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
        //Launching the URL
        getDriver().get(prop.getProperty("url"));

    }

}
