package com.demoTestcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager; 

public class BrandscopeAdminLogin {

	static WebDriver driver;
	@BeforeTest
	static void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qa-erp.brandscope.com.au/users/sign_in");
		driver.manage().window().maximize();
	}
	
	@Test 
	static void verifyUserLoginAsBSAdmin() throws IOException, Exception
	{
		csvreader.readCSVSheet();
//		//driver.findElement(By.cssSelector("a#w-node-_7901208a-7799-8dd0-0aed-81f88b308563-b32f4091")).click();
//		driver.findElement(By.cssSelector("input#user_username")).sendKeys("josh.brandscope1@gmail.com");
//		driver.findElement(By.cssSelector("input#user_password")).sendKeys("josh$123#");
//		driver.findElement(By.cssSelector("input.btn-primary")).click();
//		String ActualUrl= driver.getCurrentUrl();
//		System.out.println(ActualUrl);
	}
	
	@AfterTest
	static void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
