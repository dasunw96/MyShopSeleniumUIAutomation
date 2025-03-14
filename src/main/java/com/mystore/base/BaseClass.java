package com.mystore.base;

import com.mystore.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class BaseClass {
    public static Properties prop;
    public static ThreadLocal <RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeSuite(groups = {"Sanity", "Smoke","Regression"})
    public void loadConfig() throws IOException {
        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");
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

    @Parameters("browser")
    public static void launchWeb(String browserName){

        if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver.set(new ChromeDriver(chromeOptions));
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("IE")) {
            driver.set(new InternetExplorerDriver());
        }else if (browserName.equalsIgnoreCase("Edge")) {
            driver.set(new EdgeDriver());
        }

        //Maximize the screen
        getDriver().manage().window().maximize();
        //Delete all the cookies
        getDriver().manage().deleteAllCookies();
        //Implicit TimeOuts
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //PageLoad TimeOuts
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        //Launching the URL
        getDriver().get(prop.getProperty("url"));

    }

    @AfterSuite(groups = { "Smoke", "Regression","Sanity" })
    public void AfterSuite(){
        ExtentManager.endReport();
    }

}
