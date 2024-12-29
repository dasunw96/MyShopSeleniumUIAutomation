package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {

    Action Action = new Action();

    @FindBy(xpath = "//p[contains(text(),'Your order on My Shop is complete.')]")
    private WebElement confirmMsg;

    public OrderConfirmationPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public String validateConfirmMessage(){
        return confirmMsg.getText();
    }
}
