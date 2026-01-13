package com.devstack.selenium.waitcommands;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitCommandTest {
    public static void main(String[] args) {
        // implicitWaitExample();
        explicitWaitExample();
    }

    public static void implicitWaitExample() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/elements");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        System.out.println("Clicked on Text Box successfully");
    }

    public static void explicitWaitExample() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        element.click();
        System.out.println("Clicked on the button successfully");
    }
}
