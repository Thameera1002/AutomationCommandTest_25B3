package com.devstack.selenium.actioncommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChainedActionCommandTest {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/menu");
        WebElement mainItem = waitForElement(By.xpath("//a[text()='Main Item 2']"), 10);
        WebElement subItem = waitForElement(By.xpath("//a[text()='SUB SUB LIST »']"), 5);
        WebElement subSubItem = waitForElement(By.xpath("//a[text()='Sub Sub Item 2']"), 5);

        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem)
                .moveToElement(subItem)
                .moveToElement(subSubItem)
                .click()
                .build()
                .perform();

        Thread.sleep(2000);
    }

    public static WebElement waitForElement(By element, long time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
