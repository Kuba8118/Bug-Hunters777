package com.digital_nomads.page.dashboard;

import com.digital_nomads.page.BasePage;
import com.digital_nomads.page.users.AddUserPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    public AddUserPage addUserPage = new AddUserPage();

    @FindBy(xpath = "(//a[normalize-space()='Add user'])[2]")
    public WebElement addUserBtn;
    @FindBy(css = ".profile-menu-button")
    public WebElement profileButton;
    @FindBy(xpath = "//p[text()='Go to legacy interface']")
    public WebElement dashboardButton;
    @FindBy(xpath = "//div[@class='tl-bold-link']")
    public WebElement pages;

    public DashboardPage selectPage(String page) {
        String xpathExpression = String.format("//a[contains(text(), '%s')]", page);
        WebElement pageElement = pages.findElement(By.xpath(xpathExpression));
        webElementActions.click(pageElement);

        return this;
    }





    public AddUserPage navigateToAddUserPage() {
        webElementActions.click(addUserBtn);
        return new AddUserPage();

    }

    public DashboardPage moveToProfile() {
        profileButton.click();
        dashboardButton.click();
        return this;
    }



}
