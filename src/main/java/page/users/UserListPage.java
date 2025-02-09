package page.users;

import com.beust.ah.A;
import entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import javax.xml.namespace.QName;

public class UserListPage extends BasePage {

    //    @FindBy (css = "i[onclick=\"location='https://spacexxx.talentlms.com/user/info/id:10'\"]")
    @FindBy(xpath = "(//i[@class='icon-pencil icon-grid'])[1]")
    public WebElement clickOnChangeUser;

    @FindBy(xpath = "//tbody/tr/td[3]/span[text()='Bulat888!@gmail.com']/../../td[7]/div/div/i[@title='Edit']")
    public WebElement moovePencilBtn;

    @FindBy(xpath = "//tbody/tr/td[3]/span[text()='Bulat888!@gmail.com']/../../td[7]/div")
    public WebElement deleteBtn;

    @FindBy(xpath = "//a[@id='tl-confirm-submit' and contains(@class, 'btn-danger')]")
    public WebElement finalDeleteBtn;


    public AddUserPage isMoovePencilBtn(WebDriver driver, String name) {
        webElementActions.moveToElement(driver.findElement(By.xpath(
                "//*[text()='" + name + "']")));
        webElementActions.click(moovePencilBtn);
        return new AddUserPage();
    }

    public AddUserPage isChangeFirstname (WebDriver driver, String name) {
        webElementActions.moveToElement(moovePencilBtn).click(moovePencilBtn);
        return new AddUserPage();
    }

    public UserListPage isDeleteUser (WebDriver driver, String name) {
        webElementActions.moveToElement(deleteBtn).click(deleteBtn);
        return this;
    }

    public UserListPage isFinalDeleteUser () {
        webElementActions.click(finalDeleteBtn);
        return this;
    }


}
