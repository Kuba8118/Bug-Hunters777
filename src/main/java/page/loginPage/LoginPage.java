package page.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;
import page.dashboard.DashboardPage;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='login']")
    public WebElement login;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement incorrect;

    @FindBy(xpath ="(//span[@class='help-inline'])[1]")
    public WebElement IncorrectUserName;

    @FindBy(xpath ="(//span[@class='help-inline'])[2]")
    public WebElement IncorrectPassword;


    public DashboardPage doLogin(String username, String password) {
        webElementActions.sendKeys(login, username)
                .sendKeys(this.password,password)
                .click(submit);
        return new DashboardPage();
    }

    public LoginPage doIncorrectLogin(String username, String password) {
        webElementActions.sendKeys(login, username)
                .sendKeys(this.password,password)
                .click(submit);
        return this;
    }

    public boolean isIncorrectMessageVisible() {
        return incorrect.isDisplayed();
    }

    public boolean IncorrectUserNameMessage () {
        return IncorrectUserName.isDisplayed();
    }

    public boolean IncorrectPasswordMessage () {
        return IncorrectPassword.isDisplayed();
    }





}
