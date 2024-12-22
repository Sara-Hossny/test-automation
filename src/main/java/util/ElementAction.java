package util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_cfg.RegistrationPageCfg;

import java.time.Duration;

public class ElementAction {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ElementAction(WebDriver driver,int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));

    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        WebElement element = findElement(by);
        element.click();
    }

    public void sendKeys(By by, String keys) {
        WebElement element = findElement(by);
        element.sendKeys(keys);
    }

    public void clear(By by) {
        WebElement element = findElement(by);
        element.clear();
    }

    public String getText(By by) {
        WebElement element = findElement(by);
        return element.getText();
    }

    public void selectFromDropdown(By by, String optionText) {
        WebElement element = findElement(by);
        Select select = new Select(element);
        select.selectByVisibleText(optionText);
    }

    public boolean isElementDisplayed(By by) {
        try {
            WebElement element = findElement(by);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void hover(By by) {
        WebElement element = findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public WebElement waitForElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clickElementWhenVisible(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.click();
    }

    public String getElementAttribute(By by, String attribute) {
        WebElement element = findElement(by);
        return element.getAttribute(attribute);
    }

    public void scrollToTop(By by) {
        WebElement element = findElement(by);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = 0", element);
    }
}
