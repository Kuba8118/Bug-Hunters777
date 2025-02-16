/**
 @author Aigerim Kanybaeva
 */

import fileUtils.ConfigReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class CourseTest extends BaseDemoQATest {

    @BeforeMethod
    public void setUp(){
        driver.manage().deleteAllCookies();
        driver.get("https://agukan.talentlms.com/index");


        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        dashboardPage.mooveToProfile();
        dashboardPage.selectPage("Courses");
    }

    @Test
    public void createCourseTest(){
        coursePage = dashboardPage.navigateToAddCoursePage();
        usersPage = coursePage.createCourse(randomCourse);

        assertTrue(usersPage.isToastMessageVisible(), "The notification about the successful creation of the course did not appear.");
    }

    @Test
    public void createCourseWithNoName(){
        coursePage = dashboardPage.navigateToAddCoursePage();
        randomCourse.setCourseName("");
        coursePage.enterCourseName(randomCourse.getCourseName())
                        .enterCourseDescription(randomCourse.getCourseDescription()).saveCourse();

        assertTrue(coursePage.isNameErrorMessageDisplayed(), "The error when creating a course with an empty title is not displayed.");

    }

    @Test
    public void createCourseWithLongDescription(){
        coursePage = dashboardPage.navigateToAddCoursePage();
        String longDescription = randomCourse.getCourseDescription() + "A".repeat(5001 - randomCourse.getCourseDescription().length());
        randomCourse.setCourseDescription(longDescription);

        coursePage.enterCourseName(randomCourse.getCourseName())
                .enterCourseDescription(randomCourse.getCourseDescription()).saveCourse();

        assertTrue(coursePage.isDescErrorMessageDisplayed(), "Error message for exceeding 5000 characters in description is not displayed");
    }

    @Test
    public void sortCourseNamesByNameDescending() {
        List<String> initialCourseNames = coursePage.getCourseNames();
        assertTrue(coursePage.isSortedAscending(), "The courses are not sorted in ascending order initially.");

        coursePage.courseNameSorted();

        List<String> sortedCourseNames = coursePage.getCourseNames();
        assertTrue(coursePage.isSortedDescending(), "The courses are not sorted in descending order.");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
