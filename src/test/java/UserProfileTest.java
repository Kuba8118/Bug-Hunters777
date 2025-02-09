import entity.User;
import fileUtils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTest extends BaseDemoQATest{

//    @Test
//    public void changeUserName () {
//
//        User randomUser = randomUserGenerator.randomUser();
//
//        boolean isUpdatedMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
//                .mooveToProfile()
//                .navigateToAddUserPage()
//                .addUser(randomUser)
//                .navigateToUserListPage()
//                .isMoovePencilBtn(driver, randomUser.getEmail())
//                .changeName("Russss")
//                .isUpdatedSuccessfullyMessageVisible();
//        Assert.assertTrue(isUpdatedMessageVisible);
////        (randomUser.getUsername())
//    }

    @Test
    public void changeFirstrname () {

        User randomUser = randomUserGenerator.randomUser();

        boolean isUpdatedMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToUsersListPage()
                .isChangeFirstname(driver,randomUser.getFirstname())
                .changeFirstName("zzzzzz")
                .isUpdatedSuccessfullyMessageVisible();
        Assert.assertTrue(isUpdatedMessageVisible);
    }

    @Test
    public void changeLastrname () {

        User randomUser = randomUserGenerator.randomUser();

        boolean isUpdatedMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToUsersListPage()
                .isChangeFirstname(driver,randomUser.getFirstname())
                .changeLastName("SSSSSS")
                .isUpdatedSuccessfullyMessageVisible();
        Assert.assertTrue(isUpdatedMessageVisible);
    }

    @Test
    public void changeLoginname () {

        User randomUser = randomUserGenerator.randomUser();

        boolean isUpdatedMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToUsersListPage()
                .isChangeFirstname(driver,randomUser.getFirstname())
                .changeLoginName("BlackJack")
                .isUpdatedSuccessfullyMessageVisible();
        Assert.assertTrue(isUpdatedMessageVisible);
    }

    @Test
    public void changePasswordname () {

        User randomUser = randomUserGenerator.randomUser();

        boolean isUpdatedMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToUsersListPage()
                .isChangeFirstname(driver,randomUser.getFirstname())
                .changePasswordName("Aidin555!@#")
                .isUpdatedSuccessfullyMessageVisible();
        Assert.assertTrue(isUpdatedMessageVisible);
    }

    @Test
    public void changeEmail () {

        User randomUser = randomUserGenerator.randomUser();

        boolean isUpdatedMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToUsersListPageWithLastname()
                .isChangeFirstname(driver,randomUser.getFirstname())
                .changeEmail("Bulat888!@gmail.com")
                .isUpdatedSuccessfullyMessageVisible();
        Assert.assertTrue(isUpdatedMessageVisible);
    }

//    @Test
//    public void deleteUser () {
//        User randomUser = randomUserGenerator.randomUser();
//
//        boolean isUpdatedMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
//                .mooveToProfile()
//                .navigateToUsersListPageWithDeleteBtn()
//                .isDeleteUser(driver,randomUser.getFirstname())
//                .isFinalDeleteUser()




//        Assert.assertTrue(isUpdatedMessageVisible);

    }









}
