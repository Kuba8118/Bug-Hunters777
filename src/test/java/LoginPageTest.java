import com.digital_nomads.entity.User;
import com.digital_nomads.fileUtils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    public LoginPageTest() {
        // Пустой публичный конструктор
    }

    @BeforeTest
    public void setUp () {
        driver.get("https://khantenirm.talentlms.com/index");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        dashboardPage.moveToProfile();;

    }

    @Test
    public void loginPageTest() {

        User randomUser = randomUserGenerator.randomUser();

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .moveToProfile()
                .navigateToAddUserPage()
                .addUser(randomUser)
                .isSuccessMessageVisible();
        Assert.assertTrue(isSuccessMessageVisible);
    }

@Test
public void wrongLoginTest() {

    User randomUser = randomUserGenerator.randomUser();

    boolean isErrorDisplayed = loginPage.doIncorrectLogin("Kanat","Kanat7890")
            .isIncorrectMessageVisible();
    Assert.assertTrue(isErrorDisplayed);
}

    @Test
    public void nullLoginTest() {

        boolean isNullLoginErrorDisplayed = loginPage.doIncorrectLogin("","")
                .IncorrectUserNameMessage();
        Assert.assertTrue(isNullLoginErrorDisplayed);

        boolean isNullPasswordErrorDisplayed = loginPage.IncorrectPasswordMessage();
        Assert.assertTrue(isNullPasswordErrorDisplayed);
    }


}

