package com.digital_nomads.page.groupPage;

import com.digital_nomads.driver.Driver;
import com.digital_nomads.entity.GroupsEntity;
import com.digital_nomads.page.BasePage;
import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GroupPage extends BasePage {
    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameField;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//input[@name='submit_group']")
    public WebElement submitClick;

    @FindBy(xpath = "//a[contains(text(), 'Add group')]")
    public WebElement addGroupButton;

    @FindBy (xpath = "//span[@class='tl-group-user-name']")
    public List<WebElement> listOfUsers;

    @FindBy (xpath = "//th[@aria-label='Name']")
    public WebElement groupFilterButton;

    @FindBy(xpath = "//th[@aria-label='Description']")
    public WebElement descriptionFilterButton;



    public GroupPage createGroup(GroupsEntity groupsEntity){
        webElementActions.click(addGroupButton);
        webElementActions.sendKeys(nameField, groupsEntity.getName())
                .sendKeys(descriptionField, groupsEntity.getDescription())
                .click(submitClick);
        return new GroupPage();
    }
    public GroupPage addUserToGroup(String user){
        webElementActions.click(Driver.getDriver().findElement(By.xpath("//a/span[contains(text(), '" + user + "')]/ancestor::tr/td/div/i")));
        return new GroupPage();

    }
    public  ArrayList<GroupsEntity> getGroups(){
        List<WebElement> rows = Driver.getDriver().findElements(By.cssSelector(".outter-table-wrapper tbody tr"));
        ArrayList <GroupsEntity> groupsEntities = new ArrayList<>();

        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.cssSelector("td"));

            String groupName = cells.get(0).getText();
            String groupDescription = cells.get(1).getText();

            groupsEntities.add(new GroupsEntity(groupName, groupDescription));
        }
        return groupsEntities;


    }

    public GroupPage changeGroupName(GroupsEntity groupsEntity, String newGroupName){
        List<GroupsEntity> groups = getGroups();
        for (GroupsEntity group : groups){
            if (group.getName().equals(groupsEntity.getName())){
                webElementActions.moveToElement(Driver.getDriver().findElement(By.xpath("//span[contains(text(), '"+groupsEntity.getName()+"')]"))).actions.perform();
                webElementActions.click(Driver.getDriver().findElement(By.xpath("//span[contains(text(), '"+group.getName()+"')]/ancestor::tr/td/div//div/I[@title='Edit']")));
                webElementActions.clear(nameField);
                webElementActions.sendKeys(nameField, newGroupName);
                webElementActions.click(submitClick);

            }

        }
        return new GroupPage();

    }

    public void getCSVGroups(String filePath) {
        File file = new File(filePath);
        ArrayList<GroupsEntity> groups = getGroups();
        try {
            FileWriter outPutFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outPutFile);

            List<WebElement> headers = Driver.getDriver().findElements(By.cssSelector("thead tr"));
            for (WebElement header : headers) {
                List <WebElement> header12 = header.findElements(By.cssSelector("th"));
                String [] data = {header12.get(0).getText(), header12.get(1).getText()};
                writer.writeNext(data);
            }


            for (GroupsEntity group : groups) {
                String[] data = {group.getName(), group.getDescription()};
                writer.writeNext(data);
            }
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public GroupPage deleteGroup(GroupsEntity groupsEntity){
        List<GroupsEntity> groupsEntities = getGroups();

        for (GroupsEntity group : groupsEntities){
            if (groupsEntity.getName().equals(group.getName())){
                webElementActions.moveToElement(Driver.getDriver().findElement(By.xpath("//span[contains(text(), '"+groupsEntity.getName()+"')]"))).actions.perform();
                webElementActions.click(Driver.getDriver().findElement(By.xpath("//span[contains(text(), '"+groupsEntity.getName()+"')]/ancestor::tr/td/div/div/i[@title='Delete']")));
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='tl-confirm-submit']")));
                webElementActions.jsClick(Driver.getDriver().findElement(By.xpath("//a[@id='tl-confirm-submit']")));

            }
        }
        return new GroupPage();
    }

    public boolean isGroupListSortedAscending(){
        List<GroupsEntity> listOfGroups = getGroups();
        List<String> actualOrder = new ArrayList<>();

        for (GroupsEntity group : listOfGroups){
            actualOrder.add(group.getName());
        }

        List<String> expectedOrder = new ArrayList<>(actualOrder);
        expectedOrder.sort(String.CASE_INSENSITIVE_ORDER);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        return actualOrder.equals(expectedOrder);


    }

    public boolean isGroupListSortedDescending(){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        webElementActions.click(groupFilterButton).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@aria-sort='descending']")));


        List<GroupsEntity> listOfGroups2 = getGroups();
        List<String> actualOrder2 = new ArrayList<>();

        for (GroupsEntity group2: listOfGroups2){
            actualOrder2.add(group2.getName());
        }

        List<String> expectedOrder2 = new ArrayList<>(actualOrder2);
        expectedOrder2.sort(String.CASE_INSENSITIVE_ORDER.reversed());


        return expectedOrder2.equals(actualOrder2);
    }


    public boolean isDescriptionSortedAscending(){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        webElementActions.click(descriptionFilterButton).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@aria-sort='ascending']")));

        List<GroupsEntity> listOfDescription = getGroups();
        List<String> actualOrder = new ArrayList<>();

        for (GroupsEntity group : listOfDescription){
            actualOrder.add(group.getDescription());
        }

        List<String> expectedOrder = new ArrayList<>(actualOrder);
        expectedOrder.sort(String.CASE_INSENSITIVE_ORDER);

        return expectedOrder.equals(actualOrder);
    }

    public boolean isDescriptionSortedDescending(){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        webElementActions.click(descriptionFilterButton).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@aria-sort='descending']")));

        List<GroupsEntity> listOfDescription2 = getGroups();
        List<String> actualOrder2 = new ArrayList<>();

        for (GroupsEntity groupDescription : listOfDescription2){
            actualOrder2.add(groupDescription.getDescription());
        }

        List<String> expectedOrder2 = new ArrayList<>(actualOrder2);
        expectedOrder2.sort(String.CASE_INSENSITIVE_ORDER.reversed());

        return expectedOrder2.equals(actualOrder2);

    }

}
