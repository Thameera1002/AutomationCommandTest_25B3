package com.devstack.selenium.navigationcommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NavigationCommandTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        //driver.navigate().to(url)
        driver.navigate().to("https://www.ebay.com");
        Thread.sleep(3000);
        driver.findElement(By.id("gh-ac")).click();
        driver.findElement(By.id("gh-ac")).clear();
        driver.findElement(By.id("gh-ac")).sendKeys("iphone");
        Thread.sleep(3000);
        Select selectDropDown = new Select(driver.findElement(By.id("gh-cat")));
        selectDropDown.selectByVisibleText("Cell Phones & Accessories");
        Thread.sleep(3000);
        driver.findElement(By.id("gh-search-btn")).click();
        Thread.sleep(5000);

        //driver.navigate().back()
        driver.navigate().back();
        Thread.sleep(5000);

        //driver.navigate().forward()
        driver.navigate().forward();
        Thread.sleep(5000);

        //driver.navigate().refresh()
        driver.navigate().refresh();
        Thread.sleep(3000);
    }
}
