package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAdressesPage extends BaseClass {

    com.mystore.actiondriver.Action Action = new Action();

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    private WebElement checkoutBtn;

    public MyAdressesPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public ShippingPage clickCheckOut(){
        Action.click(getDriver(),checkoutBtn);
        return new ShippingPage();
    }
}
