package page.users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class UserProfilePage extends BasePage {

    @FindBy(xpath = "//div[@class='toast toast-info']")
    public WebElement successMessage;

    @FindBy (xpath = "//a[@title=\"Users\"]")
    public WebElement usersBtn;



    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }

    public UserListPage navigateToUserListPage () {
        usersBtn.click();
        return new UserListPage();
    }

    //td[contains(@class, 'tl-align-left')]//span[contains(@title, 'keith.koelpin')]









}
