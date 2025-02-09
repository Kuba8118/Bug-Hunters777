package page.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.internal.reflect.ArrayEndingMethodMatcher;
import page.BasePage;
import page.RandonEntityUtils.RandomUserGenerator;
import page.users.AddUserPage;
import page.users.UserListPage;
import page.users.UserProfilePage;

public class DashboardPage extends BasePage {
    public AddUserPage addUserPage = new AddUserPage();

    @FindBy(xpath = "(//a[normalize-space()='Add user'])[2]")
    public WebElement addUserBtn;
    @FindBy(css = ".profile-menu-button")
    public WebElement profileButton;
    @FindBy(xpath = "//p[text()='Go to legacy interface']")
    public WebElement dashboardButton;

    @FindBy(xpath = "//a[contains(@href, 'gridPref:reset') and normalize-space(text())='Users']")
    public WebElement usersBtn;

    @FindBy(xpath = "//tbody/tr/td[3]/span[text()='Bulat888!@gmail.com']")
    public WebElement emailElement;

    @FindBy(xpath = "//tbody/tr/td[2]/a/span[text()='D. Powlowski']")
    public WebElement lastnameElement;


    public AddUserPage navigateToAddUserPage() {
        webElementActions.click(addUserBtn);
        return new AddUserPage();

    }

    public DashboardPage mooveToProfile() {
        profileButton.click();
        dashboardButton.click();
        return this;
    }

    public UserListPage navigateToUsersListPage () {
        usersBtn.click();
        webElementActions.moveToElement(emailElement);
        return new UserListPage();
    }

    public UserListPage navigateToUsersListPageWithLastname () {
        usersBtn.click();
        webElementActions.moveToElement(lastnameElement);
        return new UserListPage();
    }

    public UserListPage navigateToUsersListPageWithDeleteBtn () {
        usersBtn.click();
        webElementActions.moveToElement(emailElement);
        return new UserListPage();
    }

    public UserListPage deleteUserS () {
        webElementActions.moveToElement(emailElement);
        if (!emailElement.equals("Bulat888!@gmail.com")) {
            // Действие, если email НЕ равен "Bulat888!@gmail.com"
            System.out.println("Email не совпадает!");
        } else {
            System.out.println("Email совпадает.");
        } return new UserListPage();
    }

}
