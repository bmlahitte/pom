package utils;


import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This will contain all wait related utility methods
 *
 */

public class WaitUtils {

    public final int explicitWaitDefault = PropertyUtils.getIntegerProperty("explicitWait", 10);

    /**
     * this method is for static wait
     */
    public void staticWait(final long millis){
        try{
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (final InterruptedException e){

        }

    }

    /**
     * To wait for a button to be clickable
     */
    public void waitForElementToBeClickable(final WebElement element, final WebDriver driver){
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * To wait for element (By) to be invisible
     */
    public void waitForElementToBeInvisible(final By locator, final WebDriver driver){
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * To wait for a given element (By) to be present
     */
    public void waitForElementToBePresent(final By locator, final WebDriver driver){
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    /**
     * To wait for a given element (By) to be visible
     */
    public void waitForElementToBeVisible(final By locator, final WebDriver driver){
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * To wait for a given element to be visible
     */
    public void waitForElementToBeVisible(final WebElement element, final WebDriver driver){
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * To wait for a given element to be visible for a given amount of time
     */
    public void waitForElementToBeVisible(final IOSElement element, final WebDriver driver, int time){
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementsToByInvisible(final List<WebElement> elements, final WebDriver driver){
        final long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public void waitForElementsToBeNotPresent(final WebDriver driver, final By locator){
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault).
                until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)));
    }

    public void waitUntilNestedElementPresent(WebElement element, By locator, WebDriver driver){
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, locator));
    }




    }
