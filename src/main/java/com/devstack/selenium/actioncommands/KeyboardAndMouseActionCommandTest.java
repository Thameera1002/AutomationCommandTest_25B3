package com.devstack.selenium.actioncommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeyboardAndMouseActionCommandTest {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        WebElement draggable = waitForElement(By.id("draggable"), 5);
        WebElement droppable = waitForElement(By.id("droppable"), 5);
        Actions action = new Actions(driver);

        action.keyDown(Keys.SHIFT)
                .clickAndHold(draggable)
                .moveToElement(droppable)
                .release()
                .keyUp(Keys.SHIFT)
                .perform();

        Thread.sleep(2000);
        WebElement verifyDropText = waitForElement(By.cssSelector("#droppable p"), 5);

        System.out.println(verifyDropText.getText());
    }

    public static WebElement waitForElement(By element, long time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
