package page.users;

import entity.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class UserListPage extends BasePage {

//    @FindBy (css = "i[onclick=\"location='https://spacexxx.talentlms.com/user/info/id:10'\"]")
    @FindBy (xpath = "(//i[@class='icon-pencil icon-grid'])[1]")
    public WebElement clickOnChangeUser;

    @FindBy (xpath = "//span[text()='kraig.daugherty@yahoo.com']")
    public WebElement moovePencilBtn;

    @FindBy (xpath = "//td[contains(@class, 'tl-align-left')]//span[contains(@title, 'keith.koelpin')]")
    public WebElement

    public AddUserPage navigateToAddUserPage () {
        clickOnChangeUser.click();
        return new AddUserPage();
    }

    public UserListPage isMoovePencilBtn () {
        moovePencilBtn.click();
        return this;
    }




}
