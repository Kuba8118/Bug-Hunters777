package page;


import com.github.javafaker.Faker;
import driver.Driver;
import helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public WebElementActions webElementActions = new WebElementActions();


    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}