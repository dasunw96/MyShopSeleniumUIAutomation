package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class IndexPageTest extends BaseClass {

    private IndexPage indexPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Sanity", "Smoke","Regression"})
    public void setup(String browser){

        launchWeb(browser);
    }
    @AfterMethod(groups = {"Sanity", "Smoke","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test (groups = "Smoke")
    public void verifyLogo(){

        indexPage = new IndexPage();
        boolean isPresentLogo = indexPage.validateLogo();
        Assert.assertTrue(isPresentLogo);
    }

    @Test (groups = "Smoke")
    public void verifyTitle(){

        String isPresentTitle = indexPage.getTitle();
        Assert.assertEquals(isPresentTitle,"My Shop");
    }
}
