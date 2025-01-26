package helper;

import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementActions {

    public Actions actions = new Actions(Driver.getDriver());


    public WebElementActions waitButtonToBeClickAble (WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(25))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeDisplayed(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions click(WebElement element) {
        waitElementToBeDisplayed(element);
        waitButtonToBeClickAble(element);
        element.click();
        return this;
    }
    public WebElementActions jsClick(WebElement element){
        waitElementToBeDisplayed(element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()",element);
        return this;
    }

    public WebElementActions sendKeys(WebElement element, String text) {
        waitElementToBeDisplayed(element);
        element.sendKeys(text);
        return this;
    }

    public WebElementActions doubleClick (WebElement element) {
        waitElementToBeDisplayed(element);
        waitButtonToBeClickAble(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementActions rightClick(WebElement element) {
        waitElementToBeDisplayed(element);
        waitButtonToBeClickAble(element);
        actions.contextClick(element).perform();
        return this;
    }

    public WebElementActions moveToElement(WebElement element) {
        waitElementToBeDisplayed(element);
        waitButtonToBeClickAble(element);
        actions.moveToElement(element).perform();
        return this;
    }

    public WebElementActions scrollToElement(WebElement element) {
        waitElementToBeDisplayed(element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", element);
        return this;
    }

    public WebElementActions hightlightElement(WebElement element){
        waitElementToBeDisplayed(element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].style.border='3px solid yellow'", element);
        return this;
    }

}
