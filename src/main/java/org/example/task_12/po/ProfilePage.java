package org.example.task_12.po;

import org.example.task_12.wrapper.Decorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {
    private WebDriver driver;

    public static final String URL = "https://demoqa.com/profile";


    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[3]/button")
    private WebElement clearCollectionButton;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[3]/button[1]")
    private WebElement submitClearCollectionButton;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProfilePage open(){
        this.driver.get(URL);
        return this;
    }

    public boolean isOpen(){
        isLoaded();
        return URL.equals(driver.getCurrentUrl());
    }

    public void clearCollection() throws InterruptedException {
        clearCollectionButton.click();
        Thread.sleep(1000);
        submitClearCollectionButton.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

}
