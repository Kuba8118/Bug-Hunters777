/**
 @author Aigerim Kanybaeva
 */

import fileUtils.ConfigReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateCourseTest extends BaseDemoQATest {

    /**
     * Настройка перед тестами: выполняется авторизация и переход на страницу добавления курса.
     */
    @BeforeTest
    public void setUp(){
        driver.get("https://agukan.talentlms.com/index");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        dashboardPage.mooveToProfile()
                .navigateToCoursesPage();
        createCoursePage = dashboardPage.navigateToAddCoursePage();
    }

    /**
     * Тест создания курса с валидными данными.
     * Проверяет успешное создание курса при правильном заполнении всех полей.
     */
    @Test
    public void createCourseTest(){
        createCoursePage.createCourseWithValidData("Course Name", "This is a description");

    }

    /**
     * Тест создания курса без названия.
     * Проверяет, что система не позволяет создать курс без заполнения обязательного поля "Название".
     */
    @Test
    public void createCourseWithNoName(){
        createCoursePage.createCourseWithInvalidData("", "This is a short description");
    }

    /**
     * Тест создания курса с длинным описанием.
     * Проверяет, что система не позволяет сохранить курс, если длина описания превышает допустимый предел.
     */
    @Test
    public void createCourseWithLongDescription(){

        String longDescription = "a".repeat(5001);
        createCoursePage.createCourseWithInvalidData("Very New Project", longDescription);
    }
}
