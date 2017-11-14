package com.qatestlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

import static com.qatestlab.setup.SeleniumDriver.getDriver;

public abstract class BasePage<T> {

    private static final String BASE_URL = "https://rozetka.com.ua";
    private static final int LOAD_TIMEOUT = 5;
    private static final int REFRESH_RATE = 2;

    protected T openPage(Class<T> clazz) {
        T page = PageFactory.initElements(getDriver(), clazz);
        getDriver().get(BASE_URL + getPageUrl());
        ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
        waitForPageToLoad(pageLoadCondition);
        return page;
    }
    private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
        Wait wait = new FluentWait(getDriver())
                .withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);

        wait.until(pageLoadCondition);
    }

    protected void waitForElement(WebElement element) {
        new WebDriverWait(getDriver(),2).until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Provides condition when page can be considered as fully loaded.
     *
     * @return
     */
    protected abstract ExpectedCondition getPageLoadCondition();

    /**
     * Provides page relative URL/
     *
     * @return
     */
    public abstract String getPageUrl();
}
