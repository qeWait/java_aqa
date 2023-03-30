package org.example.task_12.bo;

import org.example.task_12.po.BookPage;
import org.example.task_12.po.HomePage;
import org.example.task_12.po.LoginPage;
import org.example.task_12.po.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DemoqaBO {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private BookPage bookPage;

    private static final String USERNAME = "nnn";
    private static final String PASSWORD = "NNNNnnnn1234!";

    // 1.1. Go to login page
    // 1.2. Login
    // 1.3. Validate login
    // 2. Clear collection
    // 3. Add book to collection
    // 3.1. Check if the book is in the collection

    public DemoqaBO(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.profilePage = new ProfilePage(driver);
        this.bookPage = new BookPage(driver);
    }

    public DemoqaBO login() throws InterruptedException {
        // 1.1. Go to login page
        homePage.openLoginPage();
        Assert.assertTrue(loginPage.isOpen());

        // 1.2. Login
        loginPage.inputUserName(USERNAME).inputPwd(PASSWORD).submit();

        // 1.3. Validate login
//        Thread.sleep(1000);
        Assert.assertTrue(homePage.isLoggedIn(USERNAME));

        return this;
    }

    public DemoqaBO clearCollection() throws InterruptedException {
        // 2. Clear collection
        if (!profilePage.isOpen()) profilePage.open();
        profilePage.clearCollection();

        return this;
    }

    public DemoqaBO addBookInCollection() throws InterruptedException {
        // 3. Add book to collection
        homePage.open().openBookPage();
//        if (!bookPage.isOpen()) Thread.sleep(1000);
        Assert.assertTrue(bookPage.isOpen());
        bookPage.addBookInCollection();

        // 3.1. Check if the book is in the collection
//        Thread.sleep(1000);
        Assert.assertTrue(bookPage.isBookAdded());
        driver.switchTo().alert().accept();

        return this;
    }

    public void openCollectionPage() {
        profilePage.open();
    }

}
