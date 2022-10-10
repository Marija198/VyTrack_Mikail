package com.vytrack.tests;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.image.Kernel;
import java.util.concurrent.TimeUnit;

public class VyTrack {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // 1. Set up browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login ");
    }

    @Test
    public void login(){
        WebElement userName = driver.findElement(By.id("prependedInput"));

      userName.sendKeys("user38");

      WebElement password = driver.findElement(By.id("prependedInput2"));
      password.sendKeys("UserUser123");

      WebElement logIn = driver.findElement(By.id("_submit"));
      logIn.click();

      WebElement activities = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
      activities.click();

      WebElement calendar = driver.findElement(By.xpath("//span[.='Calendar Events']"));
      calendar.click();

      WebElement createEvent = driver.findElement(By.xpath("(//a[@href='/calendar/event/create'])[3]"));
        createEvent.sendKeys(Keys.ENTER);





    }
}
