package page.users;

import driver.Driver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import java.time.Duration;

public class UsersPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'toast-message')]")
    public WebElement toastMessage;

    public boolean isToastMessageVisible(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(toastMessage));
            return toastMessage.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Toast message not visible: " + e.getMessage());
            return false;
        }
    }

}
