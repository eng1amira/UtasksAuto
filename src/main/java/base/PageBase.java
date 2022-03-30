package base;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.JSWaiter;

public class PageBase {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final JSWaiter jsWaiter;

    //private static final Logger LOGGER = Logger.getLogger(PageBase.class);

    public PageBase(WebDriver driver) {
        this(driver, 60);
    }

    public PageBase(WebDriver driver, long waitInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitInSeconds);
        this.jsWaiter = new JSWaiter(driver);
    }

    public boolean isElementVisible(WebDriver driver, By elementLocator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            //LOGGER.info("Element matching this locator [ " + elementLocator + " ] is visible");
            return true;
        } catch (Exception e) {
            //LOGGER.error("Element matching this locator [ " + elementLocator + " ] is not visible");
            return false;
        }
    }

    public void moveToWrite(WebDriver driver, By elementLocator, String msg) {

        driver.findElement(elementLocator).sendKeys(msg);

    }

    public void moveToANDClick(WebDriver driver, By elementLocator) {
       /* WebElement element = null;

        element = driver.findElement(elementLocator);
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();*/

        //LOGGER.info("Moved to element and clicked successfully performed on the element");
        driver.findElement(elementLocator).click();

    }

    public boolean isElementClickable(WebDriver driver, By elementLocator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            //LOGGER.info("Element matching this locator [" + elementLocator + "] is Clickable.");
            return true;
        } catch (Exception e) {
            //LOGGER.error("Element matching this locator [" + elementLocator + "] is not Clickable.");
            return false;
        }
    }

    public void sleep(Integer milliSeconds) {
        long secondsLong = milliSeconds;
        try {
            Thread.sleep(secondsLong);
        } catch (Exception e) {
            //LOGGER.error(e.getMessage());
            // InterruptedException
        }
    }

    public void setElement(WebDriver driver, By elementLocator, String value) {

        isElementVisible(driver, elementLocator);
        try {
            driver.findElement(elementLocator).clear();
            driver.findElement(elementLocator).sendKeys(value);
            //LOGGER.info("Type " + value);
        } catch (Exception e) {
            //LOGGER.error("Can't type :" + value);
        }

    }

    public void selectItemFromList(By elementLocator, String value) {

        isElementVisible(driver, elementLocator);
        try {
            new Select(driver.findElement(elementLocator)).selectByVisibleText(value);
            //LOGGER.info("Select " + value + " :  from drop down list");
        } catch (Exception e) {
            //LOGGER.error("Can't select :" + value);
        }
    }

    public void clickElement(WebDriver driver, By elementLocator) {

        if (isElementClickable(driver, elementLocator)) {
            WebElement element = driver.findElement(elementLocator);
            element.click();
            //LOGGER.info("Click on element locator: " + elementLocator);
        } else {
            //LOGGER.error("Cannot Click on element locator: " + elementLocator);
        }
    }


}
