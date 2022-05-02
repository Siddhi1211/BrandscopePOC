package com.demoTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderSubmissionBP {
	
	static WebDriver driver;
	@BeforeTest
	static void setUp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qa-erp.brandscope.com.au/users/sign_in");
		driver.manage().window().maximize();
		
	}
	
	//@Test
	static void verifyUSerShouldSubmitBPOrder() throws InterruptedException
	{
		//driver.findElement(By.cssSelector("a#w-node-_7901208a-7799-8dd0-0aed-81f88b308563-b32f4091")).click();
				driver.findElement(By.cssSelector("input#user_username")).sendKeys("brandfactoryuser");
				driver.findElement(By.cssSelector("input#user_password")).sendKeys("Siddhi@12");
				driver.findElement(By.cssSelector("input.btn-primary")).click();
				
				driver.findElement(By.xpath("(//span[contains(text(),'Brands')])[1]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[@href='#brandModal'] //span[contains(text(),'C.O.D.E')]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//small[contains(text(),'coderelease')])[1]")).click();
				Thread.sleep(5000);
				// Remove all previous items in BP
				
				// Select product's
						//driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement(By.xpath("(//div[@class=\"sc-eqIVtm fUahYx item-info\"] /div[@class=\"item-quantity release-product\"])[3]")).click();
		        
		        Thread.sleep(3000); 
		        driver.findElement(By.linkText("Qty Grid")).click();
		        
		        driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[2]")).clear();
		        driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[2]")).sendKeys("10");

		        driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[3]")).clear();
		        driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[3]")).sendKeys("10");

		        
		        driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[4]")).clear();
		        driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[4]")).sendKeys("10");
		        
		        
		   		driver.findElement(By.xpath("(//span[@aria-hidden='true'])[1]")).click();
		 
		        driver.findElement(By.xpath("//button[@class=\"sc-jWBwVP giYJan btn btn-success\"]")).click();
		        //driver.findElement(By.id("terms_and_conditions")).click();
		        //driver.findElement(By.xpath("(//label[@for='terms_and_conditions'])[1]")).click();
		        Thread.sleep(3000);
		        WebElement element = driver.findElement(By.id("terms_and_conditions"));
		        JavascriptExecutor executor = (JavascriptExecutor)driver;
		        executor.executeScript("arguments[0].click();", element);
		       
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//button[@class=\"btn btn-primary rounded\"]")).click();
		        System.out.println("Order Placed Successfully");
				
	}
	
	@Test
	 static void verifyUserCanSubmitOrderUsingCnF() throws InterruptedException
	 {
		driver.findElement(By.cssSelector("input#user_username")).sendKeys("brandfactoryuser");
		driver.findElement(By.cssSelector("input#user_password")).sendKeys("Siddhi@12");
		driver.findElement(By.cssSelector("input.btn-primary")).click();
		
		driver.findElement(By.xpath("(//span[contains(text(),'Brands')])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='#brandModal'] //span[contains(text(),'C.O.D.E')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//small[contains(text(),'coderelease')])[2]")).click();
		Thread.sleep(5000);
		// Remove all previous items in BP
		//driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		
		// Select product's
		driver.findElement(By.xpath("(//div[@class=\"sc-eqIVtm fUahYx item-info\"] /div[@class=\"item-quantity release-product\"])[3]")).click();
       Thread.sleep(3000); 
        driver.findElement(By.linkText("Qty Grid")).click();
        
        driver.findElement(By.xpath("(//input[@value='0'])[1]")).clear();
        driver.findElement(By.xpath("(//input[@value='0'])[1]")).sendKeys("20");

        driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("5");
        
        driver.findElement(By.xpath("(//span[@aria-hidden='true'])[1]")).click();
 
        driver.findElement(By.xpath("//button[@class=\"sc-jWBwVP giYJan btn btn-success\"]")).click();
        //driver.findElement(By.id("terms_and_conditions")).click();
        //driver.findElement(By.xpath("(//label[@for='terms_and_conditions'])[1]")).click();
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("terms_and_conditions"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
       
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary rounded\"]")).click();
        System.out.println("CnF Order Placed Successfully");
		
	 }
	
	@AfterTest
	static void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
