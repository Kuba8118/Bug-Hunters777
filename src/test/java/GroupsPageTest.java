import com.digital_nomads.driver.Driver;
import com.digital_nomads.entity.GroupsEntity;
import com.digital_nomads.fileUtils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class GroupsPageTest extends BaseTest{
    @BeforeMethod
    public void setUp () {
        driver.manage().deleteAllCookies();
        driver.get("https://khantenirm.talentlms.com/index");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        dashboardPage.moveToProfile();
        dashboardPage.selectPage("Groups");

    }



    @Test(description = "verify getting a list of group", priority = 1)
    public void getGroupsTest(){

        List<GroupsEntity> groupsEntities = groupPage.getGroups();
        Assert.assertFalse(groupsEntities.isEmpty(), "Group list is empty, but it should contain groups");

    }

    @Test(description = "verify a group is deleted", priority = 3)
    public void deleteGroupTest(){
        List<GroupsEntity> groupsEntity = groupPage.getGroups();
        Random random  = new Random();
        int randomIndex = random.nextInt(groupsEntity.size());
        GroupsEntity groupToDelete = groupPage.getGroups().get(randomIndex);
        groupPage.deleteGroup(groupToDelete);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        boolean isDeleted = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//span[contains(text(), '"+groupToDelete.getName()+"')]")
        ));

        Assert.assertTrue(isDeleted, "Group wasn't deleted.");
    }

    @Test(description = "verify a group has been created and the chosen user has been added", priority = 2)
    public void createGroupAndAddUserTest(){
        GroupsEntity newGroup = randomGroupGenerator.createMockGroup();
        groupPage.createGroup(newGroup);

        boolean isGroupCreated = Driver.getDriver()
                .findElements(By.xpath("//span[contains(text(), '"+ newGroup.getName() +"')]")).size() > 0;
        Assert.assertTrue(isGroupCreated, "Group was not created");
        groupPage.addUserToGroup("Messi");

        boolean isUserAdded = Driver.getDriver()
                .findElements(By.xpath("//a/span[contains(text(), 'Messi')]/ancestor::tr//span[contains(text(), 'group member')]")).size() > 0;

        Assert.assertTrue(isUserAdded, "User wasn't added");

    }

    @Test(description = "verify a group name is change", priority = 4)
    public void changeGroupNameTest(){
        // Получаем список групп и выбираем случайную
        List<GroupsEntity> groupsEntity = groupPage.getGroups();
        Random random = new Random();
        int randomIndex = random.nextInt(groupsEntity.size());

        GroupsEntity selectedGroup = groupsEntity.get(randomIndex); // Сохраняем объект
        String oldGroupName = selectedGroup.getName(); // Запоминаем старое имя
        String newGroupName = randomGroupGenerator.randomGroupName();

        groupPage.changeGroupName(selectedGroup, newGroupName);

        List<GroupsEntity> updatedGroupsEntity = groupPage.getGroups();

        GroupsEntity updatedGroup = updatedGroupsEntity.stream()
                .filter(g -> g.getName().equals(newGroupName)) // Если есть ID, лучше искать по нему
                .findFirst()
                .orElseThrow(() -> new AssertionError("Updated group not found"));

        Assert.assertEquals(updatedGroup.getName(), newGroupName, "Group name was not updated correctly.");

    }

    @Test(description = "getting a group list in CSV format", priority = 7)
    public void groupsCSVTest(){
        String filePath = System.getProperty("user.dir") + "/src/main/resources/" + randomGroupGenerator.randomGroupName() + "_groups.csv";
        groupPage.getCSVGroups(filePath);

        // ✅ Verify that the file was created successfully
        File file = new File(filePath);
        Assert.assertTrue(file.exists(), "CSV file was not created in resources folder!");


    }

    @Test(description = "verify a list of group is sorted in ascending and descending order accordingly", priority = 5)
    public void testGroupListSorting(){

      Assert.assertTrue(groupPage.isGroupListSortedAscending(), "Group is not sorted in ascending order");
      Assert.assertTrue(groupPage.isGroupListSortedDescending(), "Group is not sorted in descending order");

    }


    @Test(description = "verify a list of group description is sorted in ascending and descending order accordingly", priority = 6)
    public void testGroupDescriptionOrder(){
        Assert.assertTrue(groupPage.isDescriptionSortedDescending(), "The description isn't sorted alphabetically");
        Assert.assertTrue(groupPage.isDescriptionSortedAscending(), "The description isn't sorted alphabetically");

    }


}
