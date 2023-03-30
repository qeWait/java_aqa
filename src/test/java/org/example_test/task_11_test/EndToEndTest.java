package org.example_test.task_11_test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.example.task_11.bo.DemoqaBO;
import org.example.task_11.po.BookPage;
import org.example.task_11.po.HomePage;
import org.example.task_11.po.LoginPage;
import org.example.task_11.po.ProfilePage;
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
        // 1.1. Go to login page
        // 1.2. Login
        // 1.3. Validate login
        // 2. Clear collection
        // 3. Add book to collection
        // 3.1. Check if the book is in the collection

        DemoqaBO demoqaBO = new DemoqaBO(driver);

        demoqaBO
                .login()
                .clearCollection()
                .addBookInCollection()
                .openCollectionPage();
    }

    @AfterTest
    void end() {
        this.driver.close();
        this.driver.quit();
    }


}
