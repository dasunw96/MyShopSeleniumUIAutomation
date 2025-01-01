package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SignupPageTest extends BaseClass {

    private IndexPage indexPage;
    private LoginPage loginPage;
    private SignUpPage signupPage;
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

    @Test (groups = "Sanity")
    public void validateNewAccountPage(){
        indexPage=new IndexPage();
        loginPage = indexPage.clickSignIn();
        signupPage = loginPage.signUp("minuga@xyz.com");
        Assert.assertTrue(signupPage.validateSignupPage());
    }

    @Test (groups = "Regression", dataProvider = "newAcountDetailsData", dataProviderClass = DataProviders.class)
    public void fillSignupForm(HashMap<String,String> userInfo){
        indexPage=new IndexPage();
        loginPage = indexPage.clickSignIn();
        signupPage = loginPage.signUp(userInfo.get("Email"));
        signupPage.fillRegisterForm(
                userInfo.get("Gender"),
                userInfo.get("FirstName"),
                userInfo.get("LastName"),
                userInfo.get("Email"),
                userInfo.get("Password"),
                userInfo.get("Day"),
                userInfo.get("Month"),
                userInfo.get("Year"));
        homePage = signupPage.createAccount();

    }


}
