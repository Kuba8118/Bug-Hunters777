import driver.Driver;
import entity.CoursesEntity;
import fileUtils.ConfigReader;
import helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import page.Component;
import page.RandonEntityUtils.RandomCourseGenerator;
import page.RandonEntityUtils.RandomUserGenerator;
import page.coursesPage.CoursePage;
import page.dashboard.DashboardPage;
import page.loginPage.LoginPage;
import page.reports.UserLoginCheck;
import page.users.AddUserPage;
import page.users.UserTableFiltration;
import page.users.UsersPage;

import java.time.Duration;

public class BaseDemoQATest {
    public WebDriver driver;

    WebElementActions webElementActions = new WebElementActions();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    AddUserPage addUserPage = new AddUserPage();
    UsersPage usersPage = new UsersPage();
    CoursePage coursePage = new CoursePage();
    RandomUserGenerator randomUserGenerator = new RandomUserGenerator();
    Component component = new Component();
    UserTableFiltration userFiltration = new UserTableFiltration();
    UserLoginCheck userLoginCheck = new UserLoginCheck();
    RandomCourseGenerator randomCourseGenerator = new RandomCourseGenerator();
    CoursesEntity randomCourse = randomCourseGenerator.generateRandomCourse();



    public static void main(String[] args) {
        System.out.println(ConfigReader.getProperty("browserType").toLowerCase());
    }

    @BeforeSuite
    public void beforeSuite(){
        driver = Driver.getDriver();
    }

//    public void waitForPageToLoad() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlContains("index"));
//    }
}

