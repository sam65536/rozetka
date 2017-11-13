package com.qatestlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    protected WebDriver getDriver() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    @AfterTest
    protected void tearDown() {
        if (driver != null)
            driver.quit();
    }
}