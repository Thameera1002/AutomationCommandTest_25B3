package com.devstack.selenium.actioncommands;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionCommandTest {
    public static void main(String[] args) throws InterruptedException {
        contextClickExample();
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
}
