package com.devstack.selenium.alertcommands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertCommandTest {
    public static void main(String[] args) throws InterruptedException {
       WebDriver driver = WebDriverManager.chromedriver().create();
       driver.manage().window().maximize();
       driver.get("https://demo.automationtesting.in/Alerts.html");
       driver.findElement(By.xpath("//a[normalize-space(text())='Alert with OK']")).click();
       driver.findElement(By.cssSelector("[class='btn btn-danger']")).click();
       Thread.sleep(3000);
       Alert alert = driver.switchTo().alert();
       System.out.println("Alert Text: " + alert.getText());
       Thread.sleep(3000);
         alert.accept();
    }
}
