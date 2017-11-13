package com.qatestlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomePageTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void testUserRegistration() throws Exception {
        driver.get("https://rozetka.com.ua/");
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        assertTrue(homePage.isUnregisteredUser());
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }
}