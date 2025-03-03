package page.RandonEntityUtils;

import com.github.javafaker.Faker;
import entity.CoursesEntity;

public class RandomCourseGenerator {
    Faker faker = new Faker();

    public CoursesEntity generateRandomCourse(){
        CoursesEntity coursesEntity = new CoursesEntity();
        coursesEntity.setCourseName(faker.educator().course());
        coursesEntity.setCourseDescription(faker.lorem().sentence());
        return coursesEntity;
    }
}
