package com.digital_nomads.page;


import com.digital_nomads.driver.Driver;
import com.digital_nomads.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class  BasePage {
    public WebElementActions webElementActions = new WebElementActions();

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}