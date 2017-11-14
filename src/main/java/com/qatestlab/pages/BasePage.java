package com.qatestlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.qatestlab.util.PageUtils.ELEMENT_LOAD_TIMEOUT;
import static com.qatestlab.util.PageUtils.SLEEP_TIMEOUT;

public abstract class BasePage {

    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, ELEMENT_LOAD_TIMEOUT, SLEEP_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement elementIfVisible (WebElement element) {
        return element.isDisplayed() ? element : null;
    }

    public void open(String url) {
        getDriver().get(url);
    }
}
