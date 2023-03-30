package org.example_test.task_11_test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
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

        
        driver.get("https://demoqa.com/books");
        // 1. Go to login page
        WebElement goToLoginPageButton = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        goToLoginPageButton.click();

        // 2. Login
        WebElement userNameInput = driver.findElement(By.cssSelector("#userName"));
        WebElement pwdInput = driver.findElement(By.cssSelector("#password"));
        WebElement submitLoginButton = driver.findElement(By.cssSelector("#login"));

        String userName = "nnn";
        String pwd = "NNNNnnnn1234!";

        userNameInput.sendKeys(userName);
        pwdInput.sendKeys(pwd);
        submitLoginButton.click();

        // 3. Validate login
        Thread.sleep(1000);
        WebElement userNameOnPage = driver.findElement(By.xpath("//*[@id=\"userName-value\"]"));
        Assert.assertEquals(userName, userNameOnPage.getText());

        // 4. Clear collection
        driver.get("https://demoqa.com/profile");
        WebElement clearCollectionButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[3]/button"));
        clearCollectionButton.click();
        Thread.sleep(1000);
        WebElement submitClearCollectionButton = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/button[1]"));
        submitClearCollectionButton.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        driver.get("https://demoqa.com/books");


        // 5. Add book to collection
        WebElement bookItem = driver.findElement(By.cssSelector("#see-book-Git\\ Pocket\\ Guide > a"));
        bookItem.click();
        Thread.sleep(1000);
        WebElement addToCollections = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
        addToCollections.click();

        // 6. Check if the book is in the collection
        Thread.sleep(1000);
        Assert.assertEquals(driver.switchTo().alert().getText(), "Book added to your collection.");
        driver.switchTo().alert().accept();
        driver.get("https://demoqa.com/profile");
    }

    @AfterTest
    void end() {
        this.driver.close();
        this.driver.quit();
    }


}
