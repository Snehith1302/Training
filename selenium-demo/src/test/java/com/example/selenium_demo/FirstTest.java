package com.example.selenium_demo;



import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	@Test
    public void testUserLogin() throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
    	WebDriverManager.firefoxdriver().setup();
    	WebDriver driver = new FirefoxDriver();

        driver.get("https://google.com");


      Thread.sleep(10000);
      driver.quit();
    }
}