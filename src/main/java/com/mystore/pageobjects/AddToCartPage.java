package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {

    com.mystore.actiondriver.Action Action = new Action();

    @FindBy(id = "group_1")
    private WebElement Size;

    @FindBy(id = "color_24")
    private WebElement Color;

    @FindBy(id = "quantity_wanted")
    private WebElement Quantity;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id='layer_cart']//h2/i")
    private WebElement addToCartPopup;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutBtn;


    public AddToCartPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean addToCart(String size, String color, String quantity ){

        Action.selectByVisibleText(size,Size);
        Action.click(getDriver(),Color);
        Action.type(Quantity,quantity);
        Action.click(getDriver(),addToCartBtn);
        Action.fluentWait(getDriver(),addToCartPopup,10);
        return Action.isDisplayed(getDriver(),addToCartPopup);
    }

    public OrderPage proceedToCheckout(){
        Action.JSClick(getDriver(),proceedToCheckoutBtn);
        return new OrderPage();
    }


}
