import driver.Driver;
import fileUtils.ConfigReader;
import helper.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import page.RandonEntityUtils.RandomUserGenerator;
import page.dashboard.DashboardPage;
import page.loginPage.LoginPage;
import page.users.AddUserPage;

public class BaseDemoQATest {
    public WebDriver driver;

    WebElementActions webElementActions = new WebElementActions();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    AddUserPage addUserPage = new AddUserPage();
    RandomUserGenerator randomUserGenerator = new RandomUserGenerator();

    public static void main(String[] args) {
        System.out.println(ConfigReader.getProperty("browserType").toLowerCase());
    }

    @BeforeSuite
    public void beforeSuite(){
        driver = Driver.getDriver();
    }

    @BeforeTest
    public void setUp () {
        driver.get("https://spacexxx.talentlms.com/index");
    }
}

