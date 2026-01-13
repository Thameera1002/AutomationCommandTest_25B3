package com.devstack.selenium.actioncommands;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionCommandTest {
    public static void main(String[] args) throws InterruptedException {
        // contextClickExample();
        doubleClickExample();
    }
    
    public static void contextClickExample() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.testmu.ai/selenium-playground/context-menu/");
        WebElement contextClickBox = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(contextClickBox).perform();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.accept();
    }

    public static void doubleClickExample() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
       driver.get("https://unixpapa.com/js/testmouse.html");
       WebElement clickableTestLink = driver.findElement(By.linkText("click here to test"));
         Actions action = new Actions(driver);
         action.doubleClick(clickableTestLink).perform();
         Thread.sleep(3000);
         @Nullable
        String domTextValue = driver.findElement(By.cssSelector("textarea")).getAttribute("value");
        System.out.println("DOM Text Area Value: " + domTextValue);
    }
}
