import driver.Driver;
import fileUtils.ConfigReader;
import helper.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import page.RandonEntityUtils.RandomUserGenerator;
import page.coursesPage.CreateCoursePage;
import page.dashboard.DashboardPage;
import page.loginPage.LoginPage;
import page.users.AddUserPage;

public class BaseDemoQATest {
    public WebDriver driver;

    WebElementActions webElementActions = new WebElementActions();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    AddUserPage addUserPage = new AddUserPage();
    CreateCoursePage createCoursePage = new CreateCoursePage();
    RandomUserGenerator randomUserGenerator = new RandomUserGenerator();

    public static void main(String[] args) {
        System.out.println(ConfigReader.getProperty("browserType").toLowerCase());
    }

    @BeforeSuite
    public void beforeSuite(){
        driver = Driver.getDriver();
    }
}

