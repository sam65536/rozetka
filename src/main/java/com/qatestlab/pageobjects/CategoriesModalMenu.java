package com.qatestlab.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoriesModalMenu extends AbstractPageObject {

    @FindBy(css = "[name='m-main-i']")
    private List<WebElement> categories;

    public CategoriesModalMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getCategories() {
        return categories;
    }

    public void getRandomMenuSubCategory() {
        Actions actions = new Actions(driver);
        actions.moveToElement(categories.get(0)).build().perform();
        List<WebElement> subCategories = driver.findElements(By.cssSelector("[name='second_level']"));
    }


}
