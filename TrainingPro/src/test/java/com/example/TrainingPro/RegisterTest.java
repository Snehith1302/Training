package com.example.TrainingPro;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest {

    @Test
    void registerTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://localhost:8081/TrainingPro/register.html");
        driver.findElement(By.id("username")).sendKeys("Ramu");
        driver.findElement(By.className("password")).sendKeys("ramu");
        driver.findElement(By.id("email")).sendKeys("ramu@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("9090909090");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
