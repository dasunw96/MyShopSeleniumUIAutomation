package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IndexPageTest extends BaseClass {

    private IndexPage indexPage;

    @BeforeMethod
    public void setup(){

        launchWeb();
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test
    public void verifyLogo(){

        indexPage = new IndexPage();
        boolean isPresentLogo = indexPage.validateLogo();
        Assert.assertTrue(isPresentLogo);
    }

    @Test
    public void verifyTitle(){

        String isPresentTitle = indexPage.getTitle();
        Assert.assertEquals(isPresentTitle,"My Shop");
    }
}
