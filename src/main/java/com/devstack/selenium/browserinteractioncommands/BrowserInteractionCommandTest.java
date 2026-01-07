package com.devstack.selenium.browserinteractioncommands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInteractionCommandTest {
    public static void main(String[] args) throws InterruptedException {
       WebDriver driver = WebDriverManager.chromedriver().create();
        //driver.navigate().to(url)
        driver.navigate().to("https://www.ebay.com");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("gh-ac"));
        element.click();
        element.clear();
        element.sendKeys("iphone"); 
       Thread.sleep(3000);
        Select selectDropDown = new Select(driver.findElement(By.id("gh-cat")));
        selectDropDown.selectByVisibleText("Cell Phones & Accessories");
        Thread.sleep(3000);
        driver.findElement(By.id("gh-search-btn")).click();
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(By.cssSelector("[class='su-media__image']"));
        
       for (int i = 0; i < elements.size(); i++) {
           if(i==0 || i==1){
            continue;
           }
            elements.get(i).click();
            // Thread.sleep(5000);
            // driver.navigate().back();
            Thread.sleep(5000);
           
       }
    }
}
