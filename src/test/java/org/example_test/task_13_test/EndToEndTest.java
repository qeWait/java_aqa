package org.example_test.task_13_test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.example.task_12.bo.DemoqaBO;
import org.example.task_13.SuiteListener;
import org.example.task_13.TestListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.example.task_12.WebDriverSupplier.driver;

@Listeners({SuiteListener.class, TestListener.class})
public class EndToEndTest {
    @BeforeTest
    void setup(){
        ChromeDriverManager.getInstance().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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
        driver.close();
        driver.quit();
    }


}
