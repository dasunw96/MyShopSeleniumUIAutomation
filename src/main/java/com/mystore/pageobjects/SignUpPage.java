package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseClass {

    Action Action = new Action();

    @FindBy(xpath = "//h1[text()='Create an account']")
    private WebElement title;

    @FindBy(id = "uniform-id_gender1")
    private WebElement mr;

    @FindBy(id = "uniform-id_gender2")
    private WebElement mrs;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement Email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement Day;

    @FindBy(id = "months")
    private WebElement Month;

    @FindBy(id = "years")
    private WebElement Year;

    @FindBy(id = "submitAccount")
    private WebElement submitBtn;

    public SignUpPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean validateSignupPage(){
        return Action.isDisplayed(getDriver(),title);
    }

    public void fillRegisterForm(
            String gender,
            String fName,
            String lName,
            String email,
            String psswd,
            String day,
            String month,
            String year){

        if (gender.equalsIgnoreCase("Mr")){
            Action.click(getDriver(),mr);
        }else{
            Action.click(getDriver(),mrs);
        }
        Action.type(firstName,fName);
        Action.type(lastName,lName);
        Action.type(Email,email);
        Action.type(password,psswd);
        Action.selectByValue(Day,day);
        Action.selectByValue(Month,month);
        Action.selectByValue(Year,year);

    }

    public HomePage createAccount(){
        Action.click(getDriver(),submitBtn);
        return new HomePage();
    }


}
