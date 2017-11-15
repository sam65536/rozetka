package com.qatestlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPageObject {

    @FindBy(name = "auth-btn")
    private WebElement signinButton;

    @FindBy(name = "profile")
    private WebElement profileButton;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "auth_submit")
    private WebElement loginSubmitButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isLoggedUser() {
        return isElementPresent(profileButton);
    }

    public void login(String email, String password) {
        signinButton.click();
        waitForElementVisibility(loginField);
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        loginSubmitButton.click();
    }
}