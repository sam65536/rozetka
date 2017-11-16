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
    public void itemsBuyTest() {
        mainPage = new MainPage();
        mainPage.open(Properties.getBaseUrl());
        assertEquals(mainPage.getCategories().size(), 17);

        WebElement currentSection = mainPage.getNotebooksSection();
//        currentSection.click();
        mainPage.open(currentSection.getAttribute("href"));
        assertEquals(driver.getTitle(), "Компьютеры и ноутбуки - Rozetka.ua | Компьютеры и ноутбуки в Киеве," +
                " Харькове, Одессе, Львове: цена, отзывы, продажа, купить оптом компьютеры и ноутбуки");

        driver.findElement(By.cssSelector("#menu_categories_left > li:nth-child(4) > p > a")).click();
        WebElement tabletItem = driver.findElement(By.cssSelector("#image_item18591041 > a"));
        mainPage.open(tabletItem.getAttribute("href"));
        ItemPage itemPage = new ItemPage();
        int tabletPrice = itemPage.getItemPrice();
        itemPage.getBuyButton().click();
        itemPage.getContinueButton().click();

        mainPage.open(Properties.getBaseUrl());
        mainPage.getTvSection().click();
        driver.findElement(By.partialLinkText("Телевизоры и аксессуары")).click();
        driver.findElement(By.partialLinkText("4K Ultra HD")).click();
        WebElement tvItem = driver.findElement(By.cssSelector("#image_item17171283 > a"));
        mainPage.open(tvItem.getAttribute("href"));
        int tvPrice = itemPage.getItemPrice();
        itemPage.getBuyButton().click();
        itemPage.getContinueButton().click();

        mainPage.open(Properties.getBaseUrl());
        mainPage.getAppliancesSection().click();
        driver.findElement(By.partialLinkText("Посудомоечные машины")).click();
        WebElement washingMachineItem = driver.findElement(By.cssSelector("#image_item12057620 > a"));
        mainPage.open(washingMachineItem.getAttribute("href"));
        int washingMachinePrice = itemPage.getItemPrice();
        itemPage.getBuyButton().click();
        itemPage.getContinueButton().click();

        mainPage.open(Properties.getBaseUrl());
        driver.navigate().refresh();
        mainPage.getCart().click();
        CartPage cartPage = new CartPage();
        int totalCost = cartPage.getTotalCost();

//        cartPage.scrollPageDown();
//        System.out.println(tabletPrice + tvPrice + washingMachinePrice);
//        System.out.println(totalCost);

        assertEquals(tabletPrice + tvPrice + washingMachinePrice, totalCost);
    }
}