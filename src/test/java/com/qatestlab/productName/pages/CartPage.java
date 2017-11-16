package com.qatestlab.productName.pages;

import com.qatestlab.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(name = "cost")
    private WebElement totalCost;

    public CartPage() {
        PageFactory.initElements(driver(), this);
    }

    public int getTotalCost() {
        return Integer.parseInt(totalCost.getText().replaceAll(" ", ""));
    }
}
