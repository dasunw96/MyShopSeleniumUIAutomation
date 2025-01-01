package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignupPageTest extends BaseClass {

    private IndexPage indexPage;
    private LoginPage loginPage;
    private SignUpPage signupPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Sanity", "Smoke","Regression"})
    public void setup(String browser){

        launchWeb(browser);
    }
    @AfterMethod(groups = {"Sanity", "Smoke","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test (groups = "Sanity")
    public void createNewAccount(){
        indexPage=new IndexPage();
        loginPage = indexPage.clickSignIn();
        signupPage = loginPage.signUp("minuga@xyz.com");
        Assert.assertTrue(signupPage.validateSignupPage());
    }


}
