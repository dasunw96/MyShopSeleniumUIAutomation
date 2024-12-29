package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    Action Action = new Action();

    @FindBy(xpath = "//h1[text()='My account']")
    private WebElement title;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement accountCreationSuccessAlert;

    @FindBy(xpath = "//span[text()='Add my first address']")
    private WebElement addFirstAddress;

    @FindBy(xpath = "//span[text()='Order history and details']']")
    private WebElement orderHistory;

    @FindBy(xpath = "//span[text()='My credit slips']']")
    private WebElement creditSlips;

    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean validateTitle(){
        return Action.isDisplayed(getDriver(),title);
    }

    public boolean validateAccountCreationSuccessAlert(){
        return Action.isDisplayed(getDriver(),accountCreationSuccessAlert);
    }

    public boolean validateAddFirstAddress(){
        return Action.isDisplayed(getDriver(),addFirstAddress);
    }

    public boolean validateOrderHistory(){
        return Action.isDisplayed(getDriver(),orderHistory);
    }

    public AddressPage addFirstAddress(){
        Action.click(getDriver(),addFirstAddress);
        return new AddressPage();
    }

}
