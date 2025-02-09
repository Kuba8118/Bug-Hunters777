package page;


import driver.Driver;
import helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
import page.dashboard.DashboardPage;

public abstract class  BasePage {
    public WebElementActions webElementActions = new WebElementActions();

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}