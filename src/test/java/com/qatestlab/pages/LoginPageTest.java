package com.qatestlab.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginPageTest extends BaseTest {
    @Test
    public void testLogin() throws Exception {
        driver.get("http://rozetka.com.ua/");
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.signIn();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//        loginPage.enterLogin("qaatest@i.ua");
//        loginPage.enterPassword("Password1");
//        loginPage.clickLoginButton();
        loginPage.login("qaatest@i.ua", "Password1");
        driver.navigate().refresh();
        assertFalse(homePage.isUnregisteredUser());
    }
}