package page.users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class UserProfilePage extends BasePage {

    @FindBy(xpath = "//div[@class='toast toast-info']")
    public WebElement successMessage;

    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }
}
