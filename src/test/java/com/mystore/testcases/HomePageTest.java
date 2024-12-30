package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    private IndexPage indexPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setup(){

        launchWeb();
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test
    public void validateOrderHistoryVisible(){

        indexPage=new IndexPage();
        loginPage = indexPage.clickSignIn();
        homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        boolean isVisible = homePage.validateOrderHistory();
        Assert.assertTrue(isVisible);
    }


}
