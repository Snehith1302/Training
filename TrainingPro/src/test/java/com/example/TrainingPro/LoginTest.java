package com.example.TrainingPro;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	@Test
	public void userLoginTest() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/selenium-demo/login.html");
		driver.findElement(By.id("uname")).sendKeys("admin");
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.id("submit")).click();
		
		Assertions.assertEquals("Dashboard", driver.getTitle());
		Thread.sleep(2000);
		
		driver.quit();
	}

}