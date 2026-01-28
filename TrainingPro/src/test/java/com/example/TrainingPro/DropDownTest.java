package com.example.TrainingPro;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {
	@Test
	public void dropDownTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8081/TrainingPro/dropdown.html");
		driver.findElement(By.id("username")).sendKeys("ramu");
		driver.findElement(By.id("email")).sendKeys("ramu@gmail.com");
		//drop down for gender
		WebElement gender=driver.findElement(By.id("gender"));
		Select genderSelect=new Select(gender);
		genderSelect.selectByVisibleText("male");
		
		//dropdown for country
		WebElement country=driver.findElement(By.id("country"));
		Select countrySelect=new Select(country);
		countrySelect.selectByValue("india");
		
		driver.findElement(By.id("submit"));
		driver.quit();

	}
}
