package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {

    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Sanity", "Smoke","Regression"})
    public void setup(String browser){

        launchWeb(browser);
    }
    @AfterMethod(groups = {"Sanity", "Smoke","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = "Regression")
    public void verifyTotalPrice(){

        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("dress");
        addToCartPage = searchResultPage.selectProduct();
        addToCartPage.addToCart("M","Pink","2");
        orderPage = addToCartPage.proceedToCheckout();
        int unitPrice = orderPage.getUnitPrice();
        int totalPrice = orderPage.getTotalPrice();
        int expectedTotal = (unitPrice*2)+7;
        Assert.assertEquals(totalPrice,expectedTotal);

    }
}
