package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {

    Action Action = new Action();

    @FindBy(xpath = "//a[contains(text(),'Pay by bank wire ')]")
    private WebElement payByBank;

    @FindBy(xpath = "//a[contains(text(),'Pay by check ')]")
    private WebElement payByCheque;

    public PaymentPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public OrderSummaryPage clickPaymentMethod(){
        Action.click(getDriver(),payByBank);
        return new OrderSummaryPage();
    }
}
