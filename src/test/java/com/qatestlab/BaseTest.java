package com.qatestlab;

import com.qatestlab.utils.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    private WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
                return new FirefoxDriver();
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                return new ChromeDriver();
        }
    }

    public void mouseHover(WebElement element) throws InterruptedException {
        String mouseOverScript =
                "if(document.createEvent) {" +
                        "var evObj = document.createEvent('MouseEvents');" +
                        "evObj.initEvent('mouseover',true, false); " +
                        "arguments[0].dispatchEvent(evObj); }";
        ((JavascriptExecutor) driver).executeScript(mouseOverScript, element);
        Thread.sleep(2000);
        Actions mouseHover = new Actions(driver);
        mouseHover.moveToElement(element).perform();
    }

    @BeforeClass
    public void setup() {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
