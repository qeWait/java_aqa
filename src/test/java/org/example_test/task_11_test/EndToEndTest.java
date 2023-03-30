package org.example_test.task_11_test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.example.task_11.BookPage;
import org.example.task_11.HomePage;
import org.example.task_11.LoginPage;
import org.example.task_11.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EndToEndTest {
    private ChromeDriver driver;

    @BeforeTest
    void setup(){
        ChromeDriverManager.getInstance().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(chromeOptions);
    }

    @Test
    void endToEndTest() throws InterruptedException {
        // target: https://demoqa.com/books
        // description: book store application
        // 1. Go to login page
        // 2. Login
        // 3. Validate login
        // 4. Clear collection
        // 5. Add book to collection
        // 6. Check if the book is in the collection

        HomePage homePage = new HomePage(this.driver);

        // 1. Go to login page
        LoginPage loginPage = homePage.openLoginPage();
        Assert.assertTrue(loginPage.isOpen());

        // 2. Login
        String userName = "nnn";
        String pwd = "NNNNnnnn1234!";

        loginPage.inputUserName(userName).inputPwd(pwd).submit();

        // 3. Validate login
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isLoggedIn(userName));

        // 4. Clear collection
        ProfilePage profilePage = new ProfilePage(this.driver);
        if (!profilePage.isOpen()) profilePage.open();
        profilePage.clearCollection();

        // 5. Add book to collection
        BookPage bookPage = homePage.open().openBookPage();
        if (!bookPage.isOpen()) Thread.sleep(1000);
        Assert.assertTrue(bookPage.isOpen());
        bookPage.addBookInCollection();

        // 6. Check if the book is in the collection
        Thread.sleep(1000);
        Assert.assertTrue(bookPage.isBookAdded());
        driver.switchTo().alert().accept();

        profilePage.open();
    }

    @AfterTest
    void end() {
        this.driver.close();
        this.driver.quit();
    }


}
