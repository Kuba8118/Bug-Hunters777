import entity.User;
import fileUtils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.users.AddUserPage;

public class AddNewUserTest extends BaseDemoQATest {

    public AddNewUserTest() {
        // Пустой публичный конструктор
    }

    @Test
    public void addNewUserTest() {

        User randomUser = randomUserGenerator.randomUser();

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addUser(randomUser)
                .isSuccessMessageVisible();
        Assert.assertTrue(isSuccessMessageVisible);
    }

    @Test
    public void InvalidUsernameLimitTest() {

        User randomUser = randomUserGenerator.randomUser();
        randomUser.setUsername(randomUserGenerator.randomUserNameMoreLimit());

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addWrongUser(randomUser)
                .isNotValidUserName();
        Assert.assertTrue(isSuccessMessageVisible);
    }

    @Test
    public void InvalidFirstnameLimitTest () {

        User randomUser = randomUserGenerator.randomUser();
        randomUser.setFirstname(randomUserGenerator.randomFirstNameMoreLimit());

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addWrongUser(randomUser)
                .isNotValidFirstName();
        Assert.assertTrue(isSuccessMessageVisible);
    }

    @Test
    public void InvalidLastnameLimitTest () {

        User randomUser = randomUserGenerator.randomUser();
        randomUser.setLastname(randomUserGenerator.randomLastNameMoreLimit());

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addWrongUser(randomUser)
                .isNotValidFirstName();
        Assert.assertTrue(isSuccessMessageVisible);
    }

    @Test
    public void InvalidEmailLimitTest () {
        User randomUser = randomUserGenerator.randomUser();
        randomUser.setEmail(randomUserGenerator.randomEmailMoreLimit());

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addWrongUser(randomUser)
                .isNotValidFirstName();
        Assert.assertTrue(isSuccessMessageVisible);
    }



    @Test
    public void WrongUserPasswordTest() {

        User randomUser = randomUserGenerator.randomUser();
        randomUser.setPassword(randomUserGenerator.randomUserWrongPassword());

        boolean isSuccessMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addWrongUser(randomUser)
                .WrongPasswordUserName();
        Assert.assertTrue(isSuccessMessageVisible);
    }

    @Test
    public void NullUserTest() {

        User randomUser = randomUserGenerator.nullUser();

        loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
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

    @Test
    public void isNullFirstname () {
        User randomUser = randomUserGenerator.nullFirstname();

        loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addNullUser(randomUser);
        boolean isNullFirstName111 = addUserPage
                .nullFirstName();
        Assert.assertTrue(isNullFirstName111);
    }

    @Test
    public void isNullLastname () {
        User randomUser = randomUserGenerator.nullLastname();

        loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addNullUser(randomUser);
        boolean isNullLastName111 = addUserPage
                .nullLastName();
        Assert.assertTrue(isNullLastName111);
    }

    @Test
    public void isNUllUsername () {
        User randomUser = randomUserGenerator.nullUsername();

        loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addNullUser(randomUser);
        boolean isNullUserName111 = addUserPage
                .nullUserName();
        Assert.assertTrue(isNullUserName111);
    }

    @Test
    public void isNullEmail () {
        User randomUser = randomUserGenerator.nullEmail();

        loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addNullUser(randomUser);
        boolean isNullEmail111 = addUserPage
                .nullEmail();
        Assert.assertTrue(isNullEmail111);
    }






}
