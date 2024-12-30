package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {

    private IndexPage indexPage;
    private SearchResultPage searchResultPage;

    @BeforeMethod
    public void setup(){

        launchWeb();
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test
    public void productAvailability(){
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("dress");
        Assert.assertTrue(searchResultPage.isProductAvailable());
    }
}
