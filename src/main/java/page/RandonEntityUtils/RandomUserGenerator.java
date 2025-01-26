package page.RandonEntityUtils;

import com.github.javafaker.Faker;
import entity.User;

public class RandomUserGenerator {

    Faker faker = new Faker();

    public String randomFirstname() {
        return faker.name().firstName();
    }

    public String randomLastname() {
        return faker.name().lastName();
    }

    public String randomEmail() {
        return faker.internet().emailAddress();
    }

    public String randomPassword() {
        return faker.internet().password();
    }

    public String randomUserName() {
        return faker.name().username();
    }

    public String randomUserNameMoreLimit() {
        return faker.lorem().characters(151);
    }

    public String randomUserWrongPassword() {
        return "1111111111";
    }

    public String NullFirstname() {
        return "";
    }

    public String NullLastname() {
        return "";
    }

    public String NullEmail() {
        return "";
    }

    public String NullPassword() {
        return "";
    }

    public String NullUserName() {
        return "";
    }

    public User randomUser() {
        return new User(randomFirstname(),randomLastname(),randomUserName(),randomEmail(),"Aidin1234!@");
    }

    public User nullUser () {
        return new User(NullFirstname(),NullLastname(),NullUserName(),NullEmail(),NullPassword());
    }



}

