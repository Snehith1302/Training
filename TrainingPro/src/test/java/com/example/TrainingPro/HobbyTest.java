package com.example.TrainingPro;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HobbyTest {
	@Test
	public void hobbyTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8081/TrainingPro/hobby.html");
		List<WebElement> hobbies=driver.findElements(By.name("hobby"));
		if(hobbies!=null) {
			for(WebElement hobby:hobbies) {
				if(!hobby.isSelected()) {
					hobby.click();
				}
			}
		}
		Assertions.assertTrue(driver.getPageSource().contains("cricket"));
		driver.findElement(By.id("submit")).click();
		driver.quit();
	}
}
