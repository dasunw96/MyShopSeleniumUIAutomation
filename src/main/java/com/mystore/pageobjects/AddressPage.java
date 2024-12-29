package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BaseClass {

    Action Action = new Action();

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "address1")
    private WebElement Address;

    @FindBy(id = "city")
    private WebElement City;

    @FindBy(id = "id_state")
    private WebElement State;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "id_country")
    private WebElement Country;

    @FindBy(id = "phone")
    private WebElement homePhone;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement AddressTitle;

    @FindBy(id = "submitAddress")
    private WebElement saveAddress;

    public MyAdressesPage addFirstAddress(
            String fName,
            String lName,
            String address,
            String city,
            String state,
            String postal,
            String country,
            String home,
            String mobile,
            String addressTitle
    ){
        Action.type(firstName,fName);
        Action.type(lastName,lName);
        Action.type(Address,address);
        Action.type(City,city);
        Action.selectByVisibleText(state,State);
        Action.type(postCode,postal);
        Action.selectByVisibleText(country,Country);
        Action.type(homePhone,home);
        Action.type(mobilePhone,mobile);
        Action.type(AddressTitle,addressTitle);
        Action.click(getDriver(),saveAddress);
        return new MyAdressesPage();
    }
}
