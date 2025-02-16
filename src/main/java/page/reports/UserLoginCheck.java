package page.reports;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import java.time.Duration;
import java.util.List;

public class UserLoginCheck extends BasePage {
    @FindBy(xpath = "//div[@class='tl-ellipsis']/a[contains(text(), 'User reports')]")
    public WebElement userReportsButton;

    @FindBy(xpath = "//li[@id='tl-navbar-logout-icon']//a")
    public WebElement logOutBtn;

    public UserLoginCheck userReportBtnClick(){
        userReportsButton.click();
        return this;
    }

    public List<WebElement> getActiveUsers(){
        return Driver.getDriver().findElements(By.xpath("//table[@id='tl-reports-users-grid']//tbody/tr"));
    }


    public String selectLastActiveUser(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        List<WebElement> activeUsers = getActiveUsers();

        WebElement lastActiveUser = activeUsers.get(0);
        List<WebElement> userColumns = lastActiveUser.findElements(By.tagName("td"));

        String lastActiveUserName = userColumns.get(0).getText().trim();
        String lastOnlineTime = userColumns.get(2).getText().trim();

        lastActiveUser.click();

        return "The last active user: " + lastActiveUserName + " \nThe last time online: " + lastOnlineTime;
    }
}
