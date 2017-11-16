package com.qatestlab.productName.tests;

import com.qatestlab.base.BaseTest;
import com.qatestlab.productName.pages.CartPage;
import com.qatestlab.productName.pages.ItemPage;
import com.qatestlab.productName.pages.MainPage;
import com.qatestlab.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainPageTest extends BaseTest {

    private static final String USER_NAME = "qaatest@i.ua";
    private static final String USER_PASSWORD = "Password1";

    private MainPage mainPage;

    @Test
    public void userLoginTest() {
        mainPage = new MainPage();
        mainPage.open(Properties.getBaseUrl());
        assertFalse(mainPage.isUserLoggedIn(), "user is not authorized");
        mainPage.login(USER_NAME, USER_PASSWORD);
        assertTrue(mainPage.isUserLoggedIn(), "user successfully logged");
    }

    @Test
    public void categoriesMenuTest() throws InterruptedException {
        mainPage = new MainPage();
        mainPage.open(Properties.getBaseUrl());
        assertEquals(mainPage.getCategories().size(), 17);

        WebElement currentSection = mainPage.getNotebooksSection();
//        element.click();
        mainPage.open(currentSection.getAttribute("href"));
        assertEquals(driver.getTitle(), "Компьютеры и ноутбуки - Rozetka.ua | Компьютеры и ноутбуки в Киеве," +
                " Харькове, Одессе, Львове: цена, отзывы, продажа, купить оптом компьютеры и ноутбуки");

        currentSection = driver.findElement(By.cssSelector("#menu_categories_left > li:nth-child(4) > p > a"));
//        mainPage.open(element.getAttribute("href"));
        currentSection.click();

        WebElement tabletItem = driver.findElement(By.cssSelector("#image_item18591041 > a"));
//      tabletItem.click();
        mainPage.open(tabletItem.getAttribute("href"));
        ItemPage itemPage = new ItemPage();
        int tabletPrice = itemPage.getItemPrice();
        itemPage.getBuyButton().click();
        itemPage.getContinueButton().click();

        mainPage.open(Properties.getBaseUrl());

        currentSection = mainPage.getTvSection();
        currentSection.click();
//        mainPage.open(element.getAttribute("href"));
        currentSection = driver.findElement(By.partialLinkText("Телевизоры и аксессуары"));
        currentSection.click();
//        mainPage.open(element.getAttribute("href"));
        currentSection = driver.findElement(By.partialLinkText("4K Ultra HD"));
        currentSection.click();
//        mainPage.open(element.getAttribute("href"));
        currentSection = driver.findElement(By.cssSelector("#image_item17171283 > a"));
        mainPage.open(currentSection.getAttribute("href"));

        int tvPrice = itemPage.getItemPrice();
        itemPage.getBuyButton().click();
        itemPage.getContinueButton().click();

        mainPage.open(Properties.getBaseUrl());

        currentSection = mainPage.getAppliancesSection();
        currentSection.click();
//        mainPage.open(element.getAttribute("href"));
        currentSection = driver.findElement(By.partialLinkText("Посудомоечные машины"));
        currentSection.click();
//        mainPage.open(element.getAttribute("href"));
        currentSection = driver.findElement(By.cssSelector("#image_item12057620 > a"));
        mainPage.open(currentSection.getAttribute("href"));

        int washingMachinePrice = itemPage.getItemPrice();
        itemPage.getBuyButton().click();
        itemPage.getContinueButton().click();

        mainPage.open(Properties.getBaseUrl());
        driver.navigate().refresh();

//        mainPage.getCart().click();
        mainPage.openCart();
        CartPage cartPage = new CartPage();
        int totalCost = cartPage.getTotalCost();

//        mainPage.scrollPageDown();
//        System.out.println(tabletPrice + tvPrice + washingMachinePrice);
//        System.out.println(totalCost);

        assertEquals(tabletPrice + tvPrice + washingMachinePrice, totalCost);
        Thread.sleep(5000);
    }
}