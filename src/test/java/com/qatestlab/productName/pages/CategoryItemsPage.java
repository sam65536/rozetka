package com.qatestlab.productName.pages;

import com.qatestlab.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryItemsPage extends BasePage {

    @FindBy(css = "[id^='image_item'] > a")
    private List<WebElement> items;

    public CategoryItemsPage() {
        PageFactory.initElements(driver(), this);
    }

    private List<WebElement> getVisibleItems() {
        List<WebElement> visibleItems = new ArrayList<>();
        for (WebElement item : items) {
            if (item.isDisplayed()) {
                visibleItems.add(item);
            }
        }
    return visibleItems;
    }

    public WebElement getRandomItem() {
        int randomItemIndex = new Random().nextInt(getVisibleItems().size());
        return getVisibleItems().get(randomItemIndex);
    }
}
