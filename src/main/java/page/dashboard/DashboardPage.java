package page.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;
import page.users.AddUserPage;

public class DashboardPage extends BasePage {
    public AddUserPage addUserPage = new AddUserPage();

    @FindBy(xpath = "(//a[normalize-space()='Add user'])[2]")
    public WebElement addUserBtn;
    @FindBy(css = ".profile-menu-button")
    public WebElement profileButton;
    @FindBy(xpath = "//p[text()='Go to legacy interface']")
    public WebElement dashboardButton;

    public AddUserPage navigateToAddUserPage() {
        webElementActions.click(addUserBtn);
        return new AddUserPage();

    }

    public DashboardPage mooveToProfile() {
        profileButton.click();
        dashboardButton.click();
        return this;
    }



}
