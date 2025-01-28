package page.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;
import page.coursesPage.CreateCoursePage;
import page.users.AddUserPage;

public class DashboardPage extends BasePage {
    public AddUserPage addUserPage = new AddUserPage();

    @FindBy(xpath = "(//a[normalize-space()='Add user'])[2]")
    public WebElement addUserBtn;

    @FindBy(css = ".profile-menu-button")
    public WebElement profileButton;

    @FindBy(xpath = "//p[text()='Go to legacy interface']")
    public WebElement dashboardButton;

    @FindBy(css = "#tl-admin-courses .tl-bold-link")
    public WebElement coursesButton;

    @FindBy(xpath = "//div[@id='tl-admin-courses']")
    public WebElement coursesPageLink;

    @FindBy(xpath = "//a[contains(@class, 'btn-primary') and text()='Add course']")
    public WebElement addCoursePageLink;


    public AddUserPage navigateToAddUserPage() {
        webElementActions.click(addUserBtn);
        return new AddUserPage();

    }

    public CreateCoursePage navigateToCoursesPage(){
        webElementActions.click(coursesButton);
        return new CreateCoursePage();
    }

    public CreateCoursePage navigateToAddCoursePage(){
        webElementActions.click(addCoursePageLink);
        return new CreateCoursePage();
    }

    public DashboardPage mooveToProfile() {
        profileButton.click();
        dashboardButton.click();
        return this;
    }
}
