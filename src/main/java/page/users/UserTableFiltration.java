package page.users;
/**
 @author Aigerim Kanybaeva
 */

import driver.Driver;
import entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class UserTableFiltration extends BasePage {

    //Возвращаем списко всех строк в таблице пользователей
    public List<WebElement> getRows(){
        return Driver.getDriver().findElements(By.xpath("//table[@id='tl-users-grid']//tbody/tr"));
    }

    //Метод для фильтрации по фамилии (А-Я)
    public List<User> sortUsersByLasName(){
        //Клик по заголовку столбца "User" для сортировки
        WebElement nameHeader = Driver.getDriver().findElement(By.xpath("//table[@id='tl-users-grid']//th[text()='User']"));
        nameHeader.click();

        //Получение строк таблицы с данными пользователей
        List<WebElement> rows = getRows();
        //Список users для добавления объектов пользователей типа User
        List<User> users = new ArrayList<>();

        /**
         Мы проходим по каждой строке таблицы, используя цикл for
         Для каждой строки мы находим все ячейки (td)
         Далее из первой ячейки (columns.get(0)) получаем полное имя пользователя. Мы разделяем его на имя и фамилию с помощью метода split(" "), который разделяет строку по пробелу.
         firstName — имя пользователя (если оно есть).
         lastName — фамилия пользователя (если она есть).
         Из второй ячейки (columns.get(1)) получаем email.
         Из третьей ячейки (columns.get(2)) получаем username.
         Создаем новый объект User с этими данными и добавляем его в список users.
         */
        for (WebElement row : rows){
            List<WebElement> columns = row.findElements(By.tagName("td"));
            String fullName = columns.get(0).getText();
            String[] nameParts = fullName.split(" ");

            String firstName = nameParts.length > 0 ? nameParts[0] : ""; // Если имя существует, берем его
            String lastName = nameParts.length > 1 ? nameParts[1] : ""; // Если фамилия существует, берем ее

            users.add(new User(firstName, lastName, "", "", ""));
        }
        users.sort((user1, user2) -> user1.getLastname().compareToIgnoreCase(user2.getLastname()));

        return users;
    }

    public List<User> sortUsersByLasNameReverse(){
        WebElement nameHeader = Driver.getDriver().findElement(By.xpath("//table[@id='tl-users-grid']//th[text()='User']"));
        nameHeader.click();
        nameHeader.click();

        List<WebElement> rows = getRows();

        List<User> users = new ArrayList<>();

        for (WebElement row : rows){
            List<WebElement> columns = row.findElements(By.tagName("td"));
            String fullName = columns.get(0).getText();
            String[] nameParts = fullName.split(" ");

            String firstName = nameParts.length > 0 ? nameParts[0] : ""; // Если имя существует, берем его
            String lastName = nameParts.length > 1 ? nameParts[1] : ""; // Если фамилия существует, берем ее

            users.add(new User(firstName, lastName, "", "", ""));
        }
        users.sort((user1, user2) -> user2.getLastname().compareToIgnoreCase(user1.getLastname()));

        return users;
    }
}
