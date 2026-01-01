package com.devstack.selenium.browsercommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserCommandTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        //driver.get(url)
        driver.get("https://www.ebay.com");
        Thread.sleep(3000);
        //driver.getCurrentUrl()
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        //driver.getTitle()
        String title = driver.getTitle();
        System.out.println(title);
//        driver.close();
//        driver.quit();
    }
}
