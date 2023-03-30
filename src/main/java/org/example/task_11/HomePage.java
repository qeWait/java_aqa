package org.example.task_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public static final String URL = "https://demoqa.com/books";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        if(!URL.equals(driver.getCurrentUrl())) {
            driver.get(URL);
        }
    }

    public HomePage open(){
        this.driver.get(URL);
        return this;
    }

    public LoginPage openLoginPage(){
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

        return new LoginPage(this.driver);
    }

    public boolean isLoggedIn(String userName) {
        WebElement userNameOnPage = driver.findElement(By.xpath("//*[@id=\"userName-value\"]"));
        return userName.equals(userNameOnPage.getText());
    }

    public BookPage openBookPage() {
        driver.findElement(By.cssSelector("#see-book-Git\\ Pocket\\ Guide > a")).click();
        return new BookPage(this.driver);
    }
}
