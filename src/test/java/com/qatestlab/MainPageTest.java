package com.qatestlab;

import com.qatestlab.pages.MainPage;
import com.qatestlab.utils.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
}