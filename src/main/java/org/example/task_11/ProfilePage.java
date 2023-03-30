package org.example.task_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private WebDriver driver;

    public static final String URL = "https://demoqa.com/profile";

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public ProfilePage open(){
        this.driver.get(URL);
        return this;
    }

    public boolean isOpen(){
        return URL.equals(driver.getCurrentUrl());
    }

    public void clearCollection() throws InterruptedException {
        WebElement clearCollectionButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[3]/button"));
        clearCollectionButton.click();
        Thread.sleep(1000);
        WebElement submitClearCollectionButton = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/button[1]"));
        submitClearCollectionButton.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

}
