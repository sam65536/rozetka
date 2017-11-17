package com.qatestlab.productName.pages;

import com.qatestlab.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends BasePage {

    @FindBy(css = "#detail_buy_label button")
    private WebElement buyButton;

    @FindBy(css = "#cart-popup a")
    private WebElement continueButton;

    @FindBy(css = "#price_label")
    private WebElement itemPrice;

    public ItemPage() {
       PageFactory.initElements(driver(), this);
    }

    public WebElement getBuyButton() {
        return buyButton;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public int getItemPrice() {
        return Integer.parseInt(itemPrice.getText().replaceAll(" ", ""));
    }
}
