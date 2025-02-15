package com.digital_nomads.page.users;

import com.digital_nomads.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage {

    @FindBy(xpath = "//div[@class='toast toast-info']")
    public WebElement successMessage;

    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }
}
