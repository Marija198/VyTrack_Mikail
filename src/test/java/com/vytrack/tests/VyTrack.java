package com.vytrack.tests;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
    public void login() throws InterruptedException {
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

        Thread.sleep(30000);

        WebElement selectBtn = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        selectBtn.click();

        WebElement invalidInteger = driver.findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        Thread.sleep(3000);
        invalidInteger.clear();
        Thread.sleep(3000);
        invalidInteger.sendKeys("-2" + Keys.ENTER);

        WebElement verifyErrorMessage = driver.findElement(By.xpath("(//span[.='The value have not to be less than 1.'])[3]"));

        String expectedResult = "The value have not to be less than 1.";
        String actualResult = verifyErrorMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(3000);
        invalidInteger.clear();
        invalidInteger.sendKeys("134" + Keys.ENTER);

        WebElement verifyErrorMessage2 = driver.findElement(By.xpath("(//span[.='The value have not to be more than 99.'])[3]"));

        String expectedResult2 = "The value have not to be more than 99.";
        String actualResult2 = verifyErrorMessage2.getText();

        Assert.assertEquals(actualResult, expectedResult);











    }
}
