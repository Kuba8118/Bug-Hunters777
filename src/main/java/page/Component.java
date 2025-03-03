package page;

import driver.Driver;
import enums.Role;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 @author Aigerim Kanybaeva
 */

public class Component extends BasePage{

    @FindBy(xpath = "//a[@class=\"dropdown-toggle tl-nabvar-roles-button\"]/b[@class='caret']")
    public WebElement roleDropdown;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]//li[contains(@class, 'tl-role-change-btn') and @id='tl-administrator-option']")
    public WebElement adminButton;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]//li[contains(@class, 'tl-role-change-btn') and @id='tl-trainer-option']")
    public WebElement instructorButton;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]//li[contains(@class, 'tl-role-change-btn') and @id='tl-learner-option']")
    public WebElement learnerButton;

    public void selectRole(Role role) {
        openRoleDropdown();

        WebElement roleButton;

        switch (role) {
            case ADMINISTRATOR:
                roleButton = adminButton;
                break;
            case INSTRUCTOR:
                roleButton = instructorButton;
                break;
            case LEARNER:
                roleButton = learnerButton;
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(roleButton));

        roleButton.click();
    }


    public void openRoleDropdown(){
        webElementActions.moveToElement(roleDropdown);
    }
}







//    @FindBy(xpath = "//li[@class='dropdown']//b[text()='Administrator']")
//    public WebElement roleDropdown;
//
//    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li[@id='tl-administrator-option']")
//    public WebElement adminButton;
//
//    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li[@id='tl-trainer-option']")
//    public WebElement instructorButton;
//
//    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li[@id='tl-learner-option']")
//    public WebElement learnerButton;
//
//
//    public void selectRole(String roleName){
//        openRoleDropdown();
//
//        WebElement roleButton;
//
//        switch (roleName){
//            case "Administrator":
//                roleButton = adminButton;
//                break;
//            case "Instructor":
//                roleButton = instructorButton;
//                break;
//            case "Learner":
//                roleButton = learnerButton;
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid role: " + roleName);
//        }
//        roleButton.click();
//    }
//
//
//    public void openRoleDropdown(){
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.elementToBeClickable(roleDropdown));
//        roleDropdown.click();
//    }
//}
