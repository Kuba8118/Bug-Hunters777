import entity.User;
import fileUtils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTest extends BaseDemoQATest{

    @Test
    public void changeUserName () {

        User randomUser = randomUserGenerator.randomUser();

        boolean isUpdatedMessageVisible = loginPage.doLogin(ConfigReader.getProperty("userName"),ConfigReader.getProperty("password"))
                .mooveToProfile()
                .navigateToAddUserPage()
                .addUser(randomUser)
                .navigateToUserListPage()

                .isMoovePencilBtn()
                .navigateToAddUserPage()
                        .changeName("Aidin")
                .isUpdatedSuccessfullyMessageVisible();
        Assert.assertTrue(isUpdatedMessageVisible);
    }

}
