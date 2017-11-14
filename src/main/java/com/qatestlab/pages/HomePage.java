package com.qatestlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage<HomePage> {

    @FindBy(name = "signin")
    private WebElement signinButton;

    @FindBy(name = "login")
    @CacheLookup
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "auth_submit")
    private WebElement loginSubmitButton;

    @FindBy(name = "profile")
    private WebElement profileButton;

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.titleContains("Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие");
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public boolean isSubscriberLogin() {
        try {
            waitForElement(profileButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void loginWithMailAndPassword(String email, String password) {
        signinButton.click();
        waitForElement(loginField);
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        loginSubmitButton.click();
    }

    public HomePage open() {
        return new HomePage().openPage(HomePage.class);
    }
}