package org.example.task_10;

import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SeleniumStart {
    public static void main(String[] args) {
        EdgeDriverManager.getInstance().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver cDriver = new EdgeDriver(options);
        cDriver.get("https://jsonplaceholder.typicode.com");

        cDriver.close();
        cDriver.quit();
    }
}
