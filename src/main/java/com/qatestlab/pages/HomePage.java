package com.qatestlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    final WebDriver driver;

    @FindBy(how = How.CSS, using = "[name='auth-btn']")
    private WebElement authButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isUnregisteredUser() {
        return (authButton.isDisplayed());
    }
}
