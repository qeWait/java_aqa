package org.example.task_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;

public class LoginPage {
    private WebDriver driver;

    public static final String URL = "https://demoqa.com/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpen(){
        return URL.equals(driver.getCurrentUrl());
    }

    public LoginPage inputUserName(String userName){
        driver.findElement(By.cssSelector("#userName")).sendKeys(userName);
        return this;
    }

    public LoginPage inputPwd(String password){
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        return this;
    }

    public void submit(){
        driver.findElement(By.cssSelector("#login")).click();
    }
}
