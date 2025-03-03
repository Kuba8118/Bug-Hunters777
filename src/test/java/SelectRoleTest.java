import enums.Role;
import fileUtils.ConfigReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 @author Aigerim Kanybaeva
 */

public class SelectRoleTest extends BaseDemoQATest {

    @BeforeTest
    public void setUp(){
        driver.get("https://agukan.talentlms.com/index");

        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        dashboardPage.mooveToProfile();
    }

    @Test
    public void selectRoleTest(){
        component.openRoleDropdown();
        component.selectRole(Role.LEARNER);
    }
}
