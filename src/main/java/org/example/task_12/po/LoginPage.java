package org.example.task_12.po;

import org.example.task_12.wrapper.Decorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private WebDriver driver;

    public static final String URL = "https://demoqa.com/login";

    @FindBy(css = "#userName")
    private WebElement userNameInput;
    @FindBy(css = "#password")
    private WebElement passwordInput;
    @FindBy(css = "#login")
    private WebElement submitLoginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    public boolean isOpen(){
        isLoaded();
        return URL.equals(driver.getCurrentUrl());
    }

    public LoginPage inputUserName(String userName){
        userNameInput.sendKeys(userName);
        return this;
    }

    public LoginPage inputPwd(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public void submit(){
        submitLoginButton.click();
    }
}
