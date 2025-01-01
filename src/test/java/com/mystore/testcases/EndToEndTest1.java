package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EndToEndTest1 extends BaseClass {

    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
    private LoginPage loginPage;
    private MyAdressesPage myAdressesPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private OrderSummaryPage orderSummaryPage;
    private OrderConfirmationPage orderConfirmationPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Sanity", "Smoke","Regression"})
    public void setup(String browser){

        launchWeb(browser);
    }
    @AfterMethod(groups = {"Sanity", "Smoke","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test (groups = "Regression")
    public void buyOneProductE2e(){

        Log.startTestCase("End to End Test 1");
        indexPage = new IndexPage();
        Log.info("Searching Product");
        searchResultPage = indexPage.searchProduct("dress");
        addToCartPage = searchResultPage.selectProduct();
        addToCartPage.addToCart("M","Pink","2");
        orderPage = addToCartPage.proceedToCheckout();
        loginPage = orderPage.clickCheckout();
        Log.info("User Log in");
        myAdressesPage = loginPage.loginViaCheckout(prop.getProperty("username"),prop.getProperty("password"));
        shippingPage = myAdressesPage.clickCheckOut();
        paymentPage = shippingPage.Checkout();
        Log.info("User Makes payment");
        orderSummaryPage = paymentPage.clickPaymentMethod();
        orderConfirmationPage = orderSummaryPage.confirmOrder();
        Assert.assertEquals(orderConfirmationPage.validateConfirmMessage(),"Your order on My Shop is complete.");
        Log.info("Order completed");
        Log.endTestCase("End to End Test 1");

    }
}
