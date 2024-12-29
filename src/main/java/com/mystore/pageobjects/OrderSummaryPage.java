package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BaseClass {

    Action Action = new Action();

    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrderBtn;

    public OrderSummaryPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public OrderConfirmationPage confirmOrder(){
        Action.click(getDriver(),confirmOrderBtn);
        return new OrderConfirmationPage();
    }
}
