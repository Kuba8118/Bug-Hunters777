import com.digital_nomads.driver.Driver;
import com.digital_nomads.fileUtils.ConfigReader;
import com.digital_nomads.helper.WebElementActions;
import com.digital_nomads.page.RandonEntityUtils.RandomGroupGenerator;
import com.digital_nomads.page.groupPage.GroupPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import com.digital_nomads.page.RandonEntityUtils.RandomUserGenerator;
import com.digital_nomads.page.dashboard.DashboardPage;
import com.digital_nomads.page.loginPage.LoginPage;
import com.digital_nomads.page.users.AddUserPage;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver;

    WebElementActions webElementActions = new WebElementActions();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    AddUserPage addUserPage = new AddUserPage();
    RandomUserGenerator randomUserGenerator = new RandomUserGenerator();
    RandomGroupGenerator randomGroupGenerator = new RandomGroupGenerator();
    GroupPage groupPage = new GroupPage();


    @BeforeSuite
    public void beforeSuite(){
        driver = Driver.getDriver();
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }

}

