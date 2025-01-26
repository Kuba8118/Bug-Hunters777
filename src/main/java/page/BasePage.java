package page;


import driver.Driver;
import helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class  BasePage {
    public WebElementActions webElementActions = new WebElementActions();

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}