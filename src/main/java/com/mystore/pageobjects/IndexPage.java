package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndexPage extends BaseClass{

    Action Action = new Action();

    public IndexPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy (xpath = "//a[@class='login']")
    private WebElement signIn;

    @FindBy (xpath = "//img[@class='logo img-responsive']")
    private WebElement logo;

    @FindBy (id = "search_query_top")
    private WebElement searchBox;

    @FindBy (name = "submit_search")
    private WebElement searchBtn;



    public LoginPage clickSignIn(){
        Action.fluentWait(getDriver(),signIn,10);
        Action.click(getDriver(),signIn);
        return new LoginPage();
    }

    public boolean validateLogo(){
        return Action.isDisplayed(getDriver(),logo);
    }

    public String getTitle(){
        return getDriver().getTitle();
    }

    public SearchResultPage searchProduct(String productName){
        Action.type(searchBox,productName);
        Action.click(getDriver(),searchBtn);
        return new SearchResultPage();
    }




}
