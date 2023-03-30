package org.example.task_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class HomePage {
    private WebDriver driver;

    public static final String URL = "https://demoqa.com/books";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        if(!URL.equals(driver.getCurrentUrl())) {
            driver.get(URL);
        }
    }

    public void openLoginPage(){
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
    }
}
