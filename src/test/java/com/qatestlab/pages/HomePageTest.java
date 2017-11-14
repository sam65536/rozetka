package com.qatestlab.pages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qatestlab.setup.SeleniumDriver.getDriver;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HomePageTest {

    private static final String USER_NAME = "qaatest@i.ua";
    private static final String USER_PASSWORD = "Password1";

    @BeforeClass
    public void setup() {
        getDriver().manage().window().maximize();
    }

    @Test (priority = 1)
    public void userShouldNotBeLogged() throws Exception {
        HomePage homePage = new HomePage().open();
        assertFalse(homePage.isSubscriberLogin());
    }

    @Test (priority = 2)
    public void userShouldBeLogged() throws Exception {
        HomePage homePage = new HomePage().open();
        homePage.loginWithMailAndPassword(USER_NAME, USER_PASSWORD);
        assertTrue(homePage.isSubscriberLogin());
    }

    @AfterClass
    public void tearDown() {
        if (getDriver() != null)
            getDriver().quit();
    }


}