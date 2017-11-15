package com.qatestlab.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.qatestlab.utils.Properties.getElementLoadTimeout;
import static com.qatestlab.utils.Properties.getSleepTimeout;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public abstract class AbstractPageObject {

    protected final WebDriver driver;

    protected AbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, getElementLoadTimeout(), getSleepTimeout());
        wait.until(visibilityOf(element));
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void open(String url) {
        driver.get(url);
    }
}
