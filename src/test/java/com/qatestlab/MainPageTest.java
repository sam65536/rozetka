package com.qatestlab;

import com.qatestlab.pageobjects.CategoriesModalMenu;
import com.qatestlab.pageobjects.MainPage;
import com.qatestlab.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.qatestlab.utils.Properties.getElementLoadTimeout;
import static com.qatestlab.utils.Properties.getSleepTimeout;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MainPageTest extends BaseTest {

    private static final String USER_NAME = "qaatest@i.ua";
    private static final String USER_PASSWORD = "Password1";

    private MainPage mainPage;

    @BeforeMethod
    public void init() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void userLoginTest() {
        mainPage.open(Properties.getBaseUrl());
        assertFalse(mainPage.isLoggedUser(), "user is not authorized");
        mainPage.login(USER_NAME, USER_PASSWORD);
        assertTrue(mainPage.isLoggedUser(), "user successfully logged");
    }

    @Test
    public void categoriesMenuTest() throws InterruptedException {
        mainPage.open(Properties.getBaseUrl());
        CategoriesModalMenu menu = new CategoriesModalMenu(driver);
        assertEquals(menu.getCategories().size(), 17);
        WebElement element = driver.findElement(By.cssSelector("#\\32 416 > a"));
        mouseHover(element);
//        ((JavascriptExecutor)driver).executeScript("$('#\\32 416 > a').hover();");
//        driver.findElement(By.cssSelector("#\\34 306 > div > div.f-menu-cols > div > ul:nth-child(2) > li:nth-child(1) > a")).click();
        Thread.sleep(1000);
//        mouseHover(driver.findElement(By.cssSelector("#\\32 416 > div > div.f-menu-cols > div > ul:nth-child(2) > li:nth-child(1) > a")));
        driver.findElement(By.partialLinkText("Комплектующие")).click();
        Thread.sleep(2000);
//        WebElement element2 = menu.getCategories().get(2);
//        mouseHover.moveToElement(subCategories.get(1)).build().perform();
//        assertEquals(subCategories.size(), 15);
    }
}