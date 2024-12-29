package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {

    Action Action = new Action();

    @FindBy(id = "cgv")
    private WebElement terms;

    @FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
    private WebElement checkoutBtn;

    public ShippingPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public PaymentPage Checkout(){
        Action.click(getDriver(),terms);
        Action.click(getDriver(),checkoutBtn);
        return new PaymentPage();
    }
}
