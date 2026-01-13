package com.devstack.selenium.waitcommands;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitCommandTest {
    public static void main(String[] args) {
        implicitWaitExample();
    }

    public static void implicitWaitExample() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/elements");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        System.out.println("Clicked on Text Box successfully");
    }
}
