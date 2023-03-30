package org.example.task_12.po;

import org.example.task_12.wrapper.Decorator;
import org.example.task_12.wrapper.TextElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"userName-value\"]")
    private TextElement userNameOnPage;

    @FindBy(css = "#see-book-Git\\ Pocket\\ Guide > a")
    private WebElement bookItem;

    public static final String URL = "https://demoqa.com/books";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        if(!URL.equals(driver.getCurrentUrl())) {
            driver.get(URL);
        }
        PageFactory.initElements(new Decorator(driver), this);

    }

    public HomePage open(){
        this.driver.get(URL);
        return this;
    }

    public LoginPage openLoginPage(){
        loginButton.click();
        return new LoginPage(this.driver);
    }

    public boolean isLoggedIn(String userName) {
//        return userName.equals(userNameOnPage.getWebElement().getText());
        return userNameOnPage.waitForTextPresent(userName);
    }

    public BookPage openBookPage() {
        bookItem.click();
        return new BookPage(this.driver);
    }
}
