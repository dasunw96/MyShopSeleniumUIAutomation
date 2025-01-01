package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    private IndexPage indexPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Sanity", "Smoke","Regression"})
    public void setup(String browser){

        launchWeb(browser);
    }
    @AfterMethod(groups = {"Sanity", "Smoke","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test (dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"} )
    public void loginTest(String username, String password) {

        indexPage = new IndexPage();

        loginPage = indexPage.clickSignIn();
        homePage = loginPage.login(username,password);
        String actUrl = homePage.getCurrentUrl();
        Assert.assertEquals(actUrl,"http://www.automationpractice.pl/index.php?controller=my-account");
    }
}
