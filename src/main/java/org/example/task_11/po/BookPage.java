package org.example.task_11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BookPage {
    private WebDriver driver;

    public static final String URL = "";

    public BookPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpen() {
        return driver.getCurrentUrl().contains("?book=");
    }

    public void addBookInCollection() {
        WebElement addToCollections = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
        addToCollections.click();
    }

    public boolean isBookAdded() {
        return "Book added to your collection.".equals(driver.switchTo().alert().getText());
    }
}
