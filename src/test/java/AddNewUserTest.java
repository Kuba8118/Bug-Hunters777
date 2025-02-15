import com.digital_nomads.entity.User;
import com.digital_nomads.fileUtils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddNewUserTest extends BaseTest {

    public AddNewUserTest() {
        // Пустой публичный конструктор
    }

    @BeforeTest
    public void setUp () {
        driver.get("https://spacexxx.talentlms.com/index");
    }

    @Test
    public void addNewUserTest() {

        User randomUser = randomUserGenerator.randomUser();

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .moveToProfile()
                .navigateToAddUserPage()
                .addUser(randomUser)
                .isSuccessMessageVisible();
        Assert.assertTrue(isSuccessMessageVisible);
    }




    @Test
    public void WrongUserTest() {

        User randomUser = randomUserGenerator.randomUser();
        randomUser.setUsername(randomUserGenerator.randomUserNameMoreLimit());

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .moveToProfile()
                .navigateToAddUserPage()
                .addWrongUser(randomUser)
                .isNotValidUserName();
        Assert.assertTrue(isSuccessMessageVisible);
    }

    @Test
    public void WrongUserPasswordTest() {

        User randomUser = randomUserGenerator.randomUser();
        randomUser.setPassword(randomUserGenerator.randomUserWrongPassword());

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .moveToProfile()
                .navigateToAddUserPage()
                .addWrongUser(randomUser)
                .WrongPasswordUserName();
        Assert.assertTrue(isSuccessMessageVisible);
    }

    @Test
    public void NullUserTest() {

        User randomUser = randomUserGenerator.nullUser();

        loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .moveToProfile()
                .navigateToAddUserPage()
                .addNullUser(randomUser);
        boolean isNullFirstName111 = addUserPage
                .nullFirstName();
        Assert.assertTrue(isNullFirstName111);

        boolean isNullLastName111 = addUserPage
                .nullLastName();
        Assert.assertTrue(isNullLastName111);

        boolean isNullUserName111 = addUserPage
                .nullUserName();
        Assert.assertTrue(isNullUserName111);

        boolean isNullEmail111 = addUserPage
                .nullEmail();
        Assert.assertTrue(isNullEmail111);
    }

}
