package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {

    Action Action = new Action();

    @FindBy (xpath = "//li[@class='price']")
    private WebElement unitPrice;

    @FindBy (id = "total_price")
    private WebElement totalPrice;

    @FindBy (xpath = "//span[text()='Proceed to checkout']")
    private WebElement checkoutBtn;

    public OrderPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public Integer getUnitPrice(){
        String unitPrice1 = unitPrice.getText();
        unitPrice1=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
        int finalUnitPrice = Integer.parseInt(unitPrice1);
        return finalUnitPrice;
    }

    public Integer getTotalPrice(){
        String totalPrice1 = totalPrice.getText();
        totalPrice1=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        int finalTotalPrice = Integer.parseInt(totalPrice1);
        return finalTotalPrice;
    }

    public LoginPage clickCheckout(){
        Action.click(getDriver(),checkoutBtn);
        return new LoginPage();

    }


}
