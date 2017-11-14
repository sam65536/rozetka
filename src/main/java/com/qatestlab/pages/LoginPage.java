package com.qatestlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage<LoginPage> {

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "auth_submit")
    private WebElement loginButton;

    @FindBy(className = "flash-error")
    WebElement errorBox;

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(loginField);
    }

    @Override
    public String getPageUrl() {
        return "/signin";
    }

    public void login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isLoginError() {
        return errorBox.isDisplayed();
    }

    public String getErrorMessage() {
        return errorBox.getText();
    }


}