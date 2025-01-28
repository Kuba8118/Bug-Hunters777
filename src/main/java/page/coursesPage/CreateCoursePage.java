package page.coursesPage;

/**
@author Aigerim Kanybaeva
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class CreateCoursePage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='e.g. Introduction to Accounting']")
    public WebElement nameOfCourse;

    @FindBy(xpath = "//textarea[@placeholder='Add a course description up to 5000 characters']")
    public WebElement descriptionOfCourse;

    @FindBy(xpath = "//input[@value='Save and select users']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='css-1qyby8w']")
    public WebElement descriptionError;

    /**
     * Заполняет поле названия курса.
     * @param coursename название курса.
     * @return текущая страница CreateCoursePage.
     */
    public CreateCoursePage enterCourseName(String coursename) {
        nameOfCourse.clear();
        nameOfCourse.sendKeys(coursename);
        return this;
    }

    /**
     * Заполняет поле описания курса.
     * @param description описание курса.
     * @return текущая страница CreateCoursePage.
     */
    public CreateCoursePage enterCourseDescription(String description) {
        descriptionOfCourse.sendKeys(description);
        return this;
    }

    /**
     * Нажимает кнопку сохранения курса.
     * @return текущая страница CreateCoursePage.
     */
    public CreateCoursePage clickPublishBtn() {
        saveButton.click();
        return this;
    }

    /**
     * Создаёт курс с валидными данными.
     * @param courseName название курса.
     * @param courseDescription описание курса.
     * @return текущая страница CreateCoursePage.
     */
    public CreateCoursePage createCourseWithValidData(String courseName, String courseDescription) {
        enterCourseName(courseName);
        enterCourseDescription(courseDescription);
        clickPublishBtn();
        return this;
    }

    /**
     * Создаёт курс с невалидными данными (например, слишком длинное описание).
     * @param courseName название курса.
     * @param courseDescription описание курса.
     * @return текущая страница CreateCoursePage.
     */
    public CreateCoursePage createCourseWithInvalidData(String courseName, String courseDescription) {
        enterCourseName(courseName);
        enterCourseDescription(courseDescription);
        clickPublishBtn();
        return this;
    }
}

