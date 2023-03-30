package org.example.task_12.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button")
    private WebElement addToCollections;

    public static final String URL = "";

    public BookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isOpen() {
        isLoaded();
        return driver.getCurrentUrl().contains("?book=");
    }

    public void addBookInCollection() {
        addToCollections.click();
    }

    public boolean isBookAdded() throws InterruptedException {
        waitForAlertInMSeconds(1000);
        return "Book added to your collection.".equals(driver.switchTo().alert().getText());
    }

}
