import fileUtils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserLoginCheckTest extends BaseDemoQATest{

    @BeforeTest
    public void setUp() {
        driver.get("https://agukan.talentlms.com/index");

        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        dashboardPage.mooveToProfile();
    }

    @Test
    public void userLoginCheckTest(){
        dashboardPage.selectPage("Reports");
        userLoginCheck.userReportBtnClick();

        String result = userLoginCheck.selectLastActiveUser();

        String expectedResult = "The last active user: A. Kanybaeva \nThe last time online: A few moments ago";
        assertEquals(result, expectedResult, "The result does not match the expected value");

    }
}
