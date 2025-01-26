package page.users;

import entity.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class AddUserPage extends BasePage {

    @FindBy(xpath = "//input[@name='name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='surname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement login;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='submit_personal_details']")
    public WebElement addUserButton;

    @FindBy(xpath = "(//span[@class='help-inline'])[1]")
    public WebElement notValidUserNAme;

    @FindBy(xpath = "(//span[@class='help-inline'])[2]")
    public WebElement WrongPassword;

    @FindBy(xpath = "(//span[@class='help-inline'])[1]")
    public WebElement isNullFirstName;

    @FindBy(xpath = "(//span[@class='help-inline'])[2]")
    public WebElement isNullLastName;

    @FindBy(xpath = "(//span[@class='help-inline'])[3]")
    public WebElement isNullEmail;

    @FindBy(xpath = "(//span[@class='help-inline'])[4]")
    public WebElement isNullUserName;



    public UserProfilePage addUser(User user) {
        webElementActions.sendKeys(firstName, user.getFirstname())
                .sendKeys(lastName, user.getLastname())
                .sendKeys(login, user.getUsername())
                .sendKeys(email, user.getEmail())
                .sendKeys(password, user.getPassword())
                .click(addUserButton);
        return new UserProfilePage();
    }

    public AddUserPage addWrongUser(User user) {
        webElementActions.sendKeys(firstName, user.getFirstname())
                .sendKeys(lastName, user.getLastname())
                .sendKeys(login, user.getUsername())
                .sendKeys(email, user.getEmail())
                .sendKeys(password, user.getPassword())
                .click(addUserButton);
        return this;
    }
    public boolean isNotValidUserName () {
        return notValidUserNAme.isDisplayed();
    }

    public boolean WrongPasswordUserName () {
        return WrongPassword.isDisplayed();
    }

    public AddUserPage addNullUser(User user) {
        webElementActions.sendKeys(firstName, user.getFirstname())
                .sendKeys(lastName, user.getLastname())
                .sendKeys(login, user.getUsername())
                .sendKeys(email, user.getEmail())
                .sendKeys(password, user.getPassword())
                .click(addUserButton);
        return this;
    }

    public boolean nullFirstName () {
        return isNullFirstName.isDisplayed();
    }

    public boolean nullLastName () {
        return isNullLastName.isDisplayed();
    }

    public boolean nullEmail () {
        return isNullEmail.isDisplayed();
    }

    public boolean nullUserName () {
        return isNullUserName.isDisplayed();
    }

}

