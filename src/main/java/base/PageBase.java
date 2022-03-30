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


    public PageBase(WebDriver driver) {
        this(driver, 60);
    }

    public PageBase(WebDriver driver, long waitInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitInSeconds);
        this.jsWaiter = new JSWaiter(driver);
    }

    public boolean isElementVisible(WebDriver driver, By elementLocator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return true;
    }


    public boolean isElementClickable(WebDriver driver, By elementLocator) {

        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));

        return true;

    }

    public void sleep(Integer milliSeconds) throws InterruptedException {
        long secondsLong = milliSeconds;

        Thread.sleep(secondsLong);

    }

    public void setElement(WebDriver driver, By elementLocator, String value) {

        isElementVisible(driver, elementLocator);

        driver.findElement(elementLocator).clear();
        driver.findElement(elementLocator).sendKeys(value);


    }


    public void clickElement(WebDriver driver, By elementLocator) {

        if (isElementClickable(driver, elementLocator)) {
            WebElement element = driver.findElement(elementLocator);
            element.click();

        }
    }


}
