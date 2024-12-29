package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

    Action Action = new Action();

    @FindBy(xpath = "//img[@src='http://www.automationpractice.pl/img/p/1/0/10-home_default.jpg']")
    private WebElement product;

    public SearchResultPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean isProductAvailable(){
        return Action.isDisplayed(getDriver(),product);
    }

    public AddToCartPage selectProduct(){
        Action.click(getDriver(),product);
        return new AddToCartPage();
    }

}
