package com.qatestlab.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {

    public static WebDriver driver() {
        return BaseTest.driver;
    }

//    public void waitForElementVisibility(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver(), getElementLoadTimeout(), getSleepTimeout());
//        wait.until(visibilityOf(element));
//    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void open(String url) {
        driver().get(url);
    }

    public void mouseHover(WebElement element) throws InterruptedException {
        String mouseOverScript =
                "if(document.createEvent) {" +
                        "var evObj = document.createEvent('MouseEvents');" +
                        "evObj.initEvent('mouseover',true, false); " +
                        "arguments[0].dispatchEvent(evObj); }";
        ((JavascriptExecutor) driver()).executeScript(mouseOverScript, element);
        Thread.sleep(2000);
        Actions mouseHover = new Actions(driver());
        mouseHover.moveToElement(element).perform();
    }

    public boolean scrollPageDown(){
        JavascriptExecutor executor = (JavascriptExecutor)driver();
        executor.executeScript("window.scrollBy(0,50)");
        boolean scrollResult = (boolean) executor.executeScript(
                "var scrollBefore = $(window).scrollTop();" +
                        "window.scrollTo(scrollBefore, document.body.scrollHeight);" +
                        "return $(window).scrollTop() > scrollBefore;");
        return scrollResult;
    }
}
