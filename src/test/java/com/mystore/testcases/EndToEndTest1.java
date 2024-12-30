package com.mystore.testcases;

import com.mystore.base.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EndToEndTest1 extends BaseClass {

    @BeforeMethod
    public void setup(){

        launchWeb();
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
}
