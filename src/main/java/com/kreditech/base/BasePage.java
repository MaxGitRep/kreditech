package com.kreditech.base;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.kreditech.utilities.CaptureScreenshot.takeScreenshot;
import static org.testng.Assert.assertTrue;

/**
 * Created by pc on 19.07.2017.
 * @author Max Pavlov
 * BasePage - generic base class for all child pages.
 * Aggregates all common actions, gets/sets, waiting and checking methods.
 * Screenshot method writes image to folder formatted depends on time in millis,
 * like /screenshots/12345/123456789_clickElem.png.
 *
 */
public class BasePage<T> {

    protected WebDriver driver;
    protected WebDriverWait wait;
    //menu
    private By menuMain = By.cssSelector("#menu-main");
    private By menuFooter = By.cssSelector("#menu-footer");
    private By footer = By.cssSelector("#footer");

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 40);
    }

    protected T getPage(String url) {
        driver.get(url);
        takeScreenshot(driver);
        return (T) this;
    }

    protected By getMenuFooter() {
        return footer;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getText(By element) {
        return find(element).getText();
    }

    protected void type(String text, By element) {
        find(element).sendKeys(text);
        takeScreenshot(driver);
    }

    protected void type(Keys key, By element) {
        find(element).sendKeys(key);
        takeScreenshot(driver);
    }

    protected void click(By element) {
        find(element).click();
        takeScreenshot(driver);
    }

    protected void click(By parentElement, By childElement) {
        findByFind(parentElement, childElement).click();
        takeScreenshot(driver);
    }

    //switch focus of WebDriver to the next found window handle
    public void switchFocusToNewTab() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            takeScreenshot(driver);
        }
    }

    public void closeNewTab(String parentHandle) {
        driver.close();
        driver.switchTo().window(parentHandle);
        takeScreenshot(driver);
    }

    public void clickOnMainMenuItem(String itemName) {
        By item = By.xpath("//a[contains(text(),'" + itemName + "')]");
        click(menuMain, item);
    }

    private WebElement find(By element) {
        return driver.findElement(element);
    }

    private WebElement findByFind(By parentElement, By childElement) {
        return driver.findElement(parentElement).findElement(childElement);
    }

    protected void waitForVisibilityOf(By element, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(element), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
            } catch (StaleElementReferenceException e) {
                e.getMessage();
            }
            attempts++;
        }
        takeScreenshot(driver);
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    public void assertEqualStrings(String actual, String expected, String massage) {
        assertTrue(expected.equals(actual),
                massage + " is not expected. \nExpected: " + expected + "\nActual  : " + actual + "\n");
    }

    public void assertContainsString(String actual, String expected, String massage) {
        assertTrue(actual.contains(expected),
                massage + " is not expected. \nExpected: " + expected + "\nActual  : " + actual + "\n");
    }

    public void checkPageTitle(String pageTitle) {
        assertEqualStrings(getTitle(), pageTitle, "Page title");
    }

    public void checkPageUrl(String pageUrl){
        assertEqualStrings(getCurrentUrl(), pageUrl, "Page URL");
    }

}
