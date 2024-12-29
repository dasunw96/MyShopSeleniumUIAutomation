package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

    Action Action = new Action();

    @FindBy (xpath = "//a[@class='login']")
    private WebElement signIn;

    @FindBy (xpath = "//img[@class='logo img-responsive']")
    private WebElement logo;

    @FindBy (id = "search_query_top")
    private WebElement searchBox;

    @FindBy (name = "submit_search")
    private WebElement searchBtn;

    public IndexPage(){
        PageFactory.initElements(getDriver(),this);
    }

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
