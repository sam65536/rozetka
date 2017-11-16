package com.qatestlab.productName.pages;

import com.qatestlab.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePage {

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

    @FindBy(css = "[name='m-main-i']")
    private List<WebElement> categories;

    @FindBy(css = "#\\32 416 > a")
    private WebElement notebooksSection;

    @FindBy(css = "#\\33 361 > a")
    private WebElement tvSection;

    @FindBy(css = "#\\34 306 > a")
    private WebElement appliancesSection;

    @FindBy(partialLinkText = "Корзина")
    private WebElement cart;

    public MainPage() {
        PageFactory.initElements(driver(), this);
    }

    public List<WebElement> getCategories() {
        return categories;
    }

    public WebElement getNotebooksSection() {
        return notebooksSection;
    }

    public WebElement getTvSection() {
        return tvSection;
    }

    public WebElement getAppliancesSection() {
        return appliancesSection;
    }

    public WebElement getCart() {
        return cart;
    }

    public boolean isUserLoggedIn() {
        return isElementDisplayed(profileButton);
    }

    public void openCart() {
        open("https://my.rozetka.com.ua/cart/");
    }

    public void login(String email, String password) {
        signinButton.click();
//        waitForElementVisibility(loginField);
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        loginSubmitButton.click();
    }
}