package org.example_test.task_10_test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleWebDriverTest {

    WebDriver driver;

    @BeforeTest
    void setup(){
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

//        EdgeDriverManager.getInstance().setup();
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new EdgeDriver(options);
    }

    @Test
    void simpleWDTest() {
        //Make a testNG test case to check visibility of your elements.
        //go to the page from your variant
        driver.get("https://demoqa.com/elements");

        //choose any 5 different elements;
        //1
        WebElement navItem = driver.findElement(By.xpath("//*[@id=\"item-6\"]"));
        Assert.assertTrue(navItem.isDisplayed());

        //2
        driver.get("https://demoqa.com/broken");
        WebElement img = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/img[2]"));
        Assert.assertTrue(img.isDisplayed());

        //3
        WebElement practiceForm = driver.findElement(By.xpath("//*[@id=\"item-0\"]"));
        Assert.assertTrue(practiceForm.isDisplayed());

        //4
        driver.get("https://demoqa.com/text-box");
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        Assert.assertTrue(nameInput.isDisplayed());

        //5
        WebElement form = driver.findElement(By.xpath("//*[@id=\"userForm\"]"));
        Assert.assertTrue(form.isDisplayed());
    }

    @AfterTest
    void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
