package page.coursesPage;

/**
@author Aigerim Kanybaeva
 */

import driver.Driver;
import entity.CoursesEntity;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;
import page.users.UsersPage;
import java.util.ArrayList;
import java.util.List;

public class CoursePage extends BasePage {

    @FindBy(xpath = "//div[@class='input-append tl-countdown']//input[@name='name']")
    public WebElement nameOfCourse;

    @FindBy(xpath = "//textarea[@placeholder='Add a course description up to 5000 characters']")
    public WebElement descriptionOfCourse;

    @FindBy(xpath = "//input[@value='Save and select users']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@class='help-block']/span[@class='help-inline']")
    public WebElement nameErrorMessage;

    @FindBy(xpath = "//span[contains(@class, 'help-inline') and contains(text(), \"cannot exceed 5000 characters\")]")
    public WebElement descErrorMessage;

    @FindBy(xpath = "//th[contains(text(),'Course')]")
    public WebElement nameHeader;



    @Step("Enter course name: {0}")
    public CoursePage enterCourseName(String coursename) {
        webElementActions.sendKeys(nameOfCourse, coursename);
        return this;
    }

    @Step("Enter course description: {0}")
    public CoursePage enterCourseDescription(String description) {
        webElementActions.sendKeys(descriptionOfCourse, description);
        return this;
    }

    @Step("Click on Save button to publish the course")
    public CoursePage saveCourse() {
        webElementActions.click(saveButton);
        return this;
    }

    public UsersPage createCourse(CoursesEntity course){
        enterCourseName(course.getCourseName());
        enterCourseDescription(course.getCourseDescription());
        saveCourse();
        return new UsersPage();
    }

    public boolean isNameErrorMessageDisplayed() {
        return nameErrorMessage.isDisplayed();
    }

    public boolean isDescErrorMessageDisplayed() {
        return descErrorMessage.isDisplayed();
    }


    public CoursePage courseNameSorted(){
        webElementActions.click(nameHeader);
        return this;
    }

    @Step("Get the list of course names from the table")
    public List<String> getCourseNames() {
        List<WebElement> rows = Driver.getDriver().findElements(By.cssSelector(".outter-table-wrapper tbody tr"));
        List<String> courseNames = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector("td"));
            String courseName = cells.get(0).getText();
            courseNames.add(courseName);
        }
        return courseNames;
    }

    @Step("Check if course names are sorted in ascending order")
    public boolean isSortedAscending() {
        List<String> courseNames = getCourseNames();
        for (int i = 0; i < courseNames.size() - 1; i++) {
            if (courseNames.get(i).compareTo(courseNames.get(i + 1)) > 0) {
                return false; //
            }
        }
        return true;
    }

    @Step("Check if course names are sorted in descending order")
    public boolean isSortedDescending() {
        List<String> courseNames = getCourseNames();
        for (int i = 0; i < courseNames.size() - 1; i++) {
            if (courseNames.get(i).compareTo(courseNames.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }
}

