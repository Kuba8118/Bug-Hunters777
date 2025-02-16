package enums;

import driver.Driver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public enum Role {

    ADMINISTRATOR("Administrator"),
    INSTRUCTOR("Instructor"),
    LEARNER("Learner");

    @Getter
    private final String role; // Делаем поле final

    // Конструктор остается, но не обязателен, если используется только для инициализации
    Role(String role) {
        this.role = role;
    }

}

