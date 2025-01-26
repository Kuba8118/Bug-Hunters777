import entity.User;
import fileUtils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.loginPage.LoginPage;

public class LoginPageTest extends BaseDemoQATest {

    public LoginPageTest() {
        // Пустой публичный конструктор
    }

    @BeforeTest
    public void setUp() {
        driver.get("https://spacexxx.talentlms.com/index");
    }

    @Test
    public void loginPageTest() {

        User randomUser = randomUserGenerator.randomUser();

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .mooveToProfile()
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

