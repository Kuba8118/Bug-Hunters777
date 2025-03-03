package page.dashboard;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.coursesPage.CoursePage;
import page.reports.UserLoginCheck;
import page.users.AddUserPage;
import page.users.UserTableFiltration;

import java.time.Duration;

public class DashboardPage extends BasePage {
    public AddUserPage addUserPage = new AddUserPage();

    @FindBy(xpath = "(//a[normalize-space()='Add user'])[2]")
    public WebElement addUserBtn;

    @FindBy(css = ".profile-menu-button")
    public WebElement profileButton;

    @FindBy(xpath = "//p[text()='Go to legacy interface']")
    public WebElement dashboardButton;

    @FindBy(id = "tl-admin-users")
    public WebElement usersButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']")
    public WebElement pages;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[contains(text(), 'Categories')]")
    public WebElement categoriesButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[contains(text(), 'Groups')]")
    public WebElement groupsButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[contains(text(), 'Branches')]")
    public WebElement branchesButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[contains(text(), 'Events engine')]")
    public WebElement eventsEngineButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[contains(text(), 'User types')]")
    public WebElement userTypesButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[contains(text(), 'Import - Export')]")
    public WebElement importExportButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[contains(text(), 'Reports')]")
    public WebElement reportsButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[contains(text(), 'Account & Settings')]")
    public WebElement accountSettingsButton;

    @FindBy(xpath = "//a[contains(@class, 'btn-primary') and text()='Add course']")
    public WebElement addCoursePageLink;


    public AddUserPage navigateToAddUserPage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

        // Ожидание, пока кнопка станет видимой
        WebElement addUserButton = wait.until(ExpectedConditions.elementToBeClickable(addUserBtn));
        // Ожидание кликабельности кнопки
        wait.until(ExpectedConditions.elementToBeClickable(addUserButton)).click();

        return new AddUserPage();
    }

    public DashboardPage selectPage(String page) {
        String xpathExpression = String.format("//a[contains(text(), '%s')]", page);
        WebElement pageElement = pages.findElement(By.xpath(xpathExpression));
        webElementActions.click(pageElement);

        return this;
    }

//    public CreateCoursePage navigateToCoursesPage(){
//        webElementActions.click(coursesButton);
//        return new CreateCoursePage();
//    }

    public CoursePage navigateToAddCoursePage() {
        webElementActions.click(addCoursePageLink);

        // Проверяем, что URL изменился на тот, который должен быть для страницы добавления курса
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/create"));

        return new CoursePage();
    }


    public UserTableFiltration navigateToUsersPage(){
        webElementActions.click(usersButton);
        return new UserTableFiltration();
    }

    public UserLoginCheck navigateToReportsPage(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        webElementActions.click(reportsButton);
        return new UserLoginCheck();
    }


    public DashboardPage mooveToProfile() {
        profileButton.click();
        dashboardButton.click();
        return this;
    }
}
