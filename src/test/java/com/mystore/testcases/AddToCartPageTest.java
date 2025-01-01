package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {

    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Sanity", "Smoke","Regression"})
    public void setup(String browser){

        launchWeb(browser);
    }
    @AfterMethod(groups = {"Sanity", "Smoke","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test (groups = {"Regression","Sanity"})
    public void addToCartTest(){
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("dress");
        addToCartPage = searchResultPage.selectProduct();
        Assert.assertTrue(addToCartPage.addToCart("M","Pink","2"));

    }
}
