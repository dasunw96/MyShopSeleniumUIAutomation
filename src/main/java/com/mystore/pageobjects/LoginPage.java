package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    Action Action = new Action();

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;

    @FindBy(id = "email_create")
    private WebElement createAccountEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountBtn;

    public LoginPage () {
        PageFactory.initElements(getDriver(),this);
    }

    public HomePage login(String uname, String passwd){
        Action.type(email,uname);
        Action.type(password,passwd);
        Action.click(getDriver(),signInBtn);
        return new HomePage();

    }

    public MyAdressesPage loginViaCheckout(String uname, String passwd){
        Action.type(email,uname);
        Action.type(password,passwd);
        Action.click(getDriver(),signInBtn);
        return new MyAdressesPage();

    }

    public SignUpPage signUp(String email){
        Action.type(createAccountEmail,email);
        Action.click(getDriver(),createAccountBtn);
        return new SignUpPage();

    }
}
