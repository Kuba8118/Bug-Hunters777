import entity.User;
import fileUtils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 @author Aigerim Kanybaeva
 */

public class UserFiltrationTest extends BaseDemoQATest{

    @BeforeTest
    public void setUp() {
        driver.get("https://agukan.talentlms.com/index");

        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        dashboardPage.mooveToProfile();
    }

    @Test
    public void userTableFiltration(){
        dashboardPage.navigateToUsersPage();

        List<User> sortedUsers = userFiltration.sortUsersByLasName();

        boolean isSorted = true;
        for (int i = 1; i < sortedUsers.size(); i++){
            if (sortedUsers.get(i).getLastname().compareToIgnoreCase(sortedUsers.get(0).getLastname()) < 0){
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The last names of users are not sorted correctly");
    }

    @Test
    public void userTableFiltrationReverse(){
        dashboardPage.navigateToUsersPage();

        List<User> sortedUsers = userFiltration.sortUsersByLasNameReverse();

        boolean isSorted = true;
        for (int i = 1; i < sortedUsers.size(); i++){
            if (sortedUsers.get(i).getLastname().compareToIgnoreCase(sortedUsers.get(0).getLastname()) < 0){
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The last names of users are not sorted correctly");
    }


}
