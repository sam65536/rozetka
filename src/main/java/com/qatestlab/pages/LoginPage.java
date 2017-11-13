package com.qatestlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    final WebDriver driver;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "auth_submit")
    private WebElement loginButton;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public void enterLogin (String login) {
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterPassword (String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public HomePage login (String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickLoginButton();
        return PageFactory.initElements(driver, HomePage.class);
    }
}