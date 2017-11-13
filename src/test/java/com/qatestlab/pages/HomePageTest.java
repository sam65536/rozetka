package com.qatestlab.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest {

    @Test
    public void testUserRegistration() throws Exception {
        driver.get("http://rozetka.com.ua/");
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        assertTrue(homePage.isUnregisteredUser());
    }
}