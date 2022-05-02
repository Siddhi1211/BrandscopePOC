package com.demoTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpPage{
	
	WebDriver driver;
	@Test()
	void VerifyIfUserAbleToSignUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qa-erp.brandscope.com.au/");
		driver.manage().window().maximize();
	
	driver.findElement(By.id("w-node-_7901208a-7799-8dd0-0aed-81f88b308563-b32f4091")).click();
	
	driver.findElement(By.xpath("(//a[normalize-space()='Not a member, sign up here'])[1]")).click();
	
	driver.findElement(By.id("registration_first_name")).sendKeys("Siddhi");
	driver.findElement(By.id("registration_last_name")).sendKeys("Raut");
	driver.findElement(By.id("registration_email")).sendKeys("siddhiraut1211@gmail.com");
	driver.findElement(By.id("registration_phone")).sendKeys("1234567890");
	driver.findElement(By.id("registration_company_name")).sendKeys("C.O.D.E");
	//driver.findElement(By.id("")).sendKeys("");
	
	
	Select drpCountry = new Select(driver.findElement(By.id("registration_company_type")));
	drpCountry.selectByVisibleText("Supplier");

	Select drpCountry1 = new Select(driver.findElement(By.id("registration_reference_source")));
	drpCountry1.selectByVisibleText("Digital media");

	driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
	
	
	}
	
	

}
