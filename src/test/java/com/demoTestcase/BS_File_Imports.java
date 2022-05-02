package com.demoTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class BS_File_Imports {
	static WebDriver driver;
	@Test
	void verifyUserCanImportsDLS() throws InterruptedException
	{
	//	verifyUserLoginAsBSAdmin();
		//DLS Import
		WebElement ele = driver.findElement(By.xpath("//span[@class='with_arrow']//span[contains(text(),'Administration')]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath("//span[normalize-space()='Product DLS Import']")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("btn-icon")).click();
		Thread.sleep(5000);
	
		//Select Brand
		WebElement testDropDown = driver.findElement(By.id("product_upload_brand"));
		testDropDown.click();
		Select dropdown = new Select(testDropDown);
        dropdown.selectByVisibleText("C.O.D.E");
		
        // Select Release 
        Thread.sleep(5000);
        WebElement testDropDown1 = driver.findElement(By.id("product_upload_release"));
		testDropDown1.click();
		Select dropdown1 = new Select(testDropDown1);
        dropdown1.selectByVisibleText("coderelease");
        
        //Select Format
        Thread.sleep(5000);
        WebElement testDropDown2 = driver.findElement(By.id("product_upload_format"));
      	testDropDown2.click();
      	Select dropdown2 = new Select(testDropDown2);
        dropdown2.selectByVisibleText("Supplier");  
        
        //Uploading File
        WebElement uploadElement =driver.findElement(By.id("product_upload_file"));	
        uploadElement.sendKeys("/home/josh/Documents/C.O.D.E_DLS.csv");
        Thread.sleep(5000);
        
        //Validate File Button
        WebElement validate= driver.findElement(By.id("productUploadValidate"));
        validate.click();
        Thread.sleep(5000);
        
        //Upload File Button
        WebElement upload= driver.findElement(By.id("productUploadBtn"));
        upload.click();
    
	}
	@Test 
	void verifyUserCanUploadATS() throws InterruptedException
	{
		//verifyUserLoginAsBSAdmin();
		driver.findElement(By.cssSelector("input#user_username")).sendKeys("josh.brandscope1@gmail.com");
		driver.findElement(By.cssSelector("input#user_password")).sendKeys("josh$123#");
		driver.findElement(By.cssSelector("input.btn-primary")).click();
		
		WebElement ele = driver.findElement(By.xpath("//span[@class='with_arrow']//span[contains(text(),'Administration')]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[@href=\"/events/ats\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("icon-plus")).click();
		Thread.sleep(5000);
		
		//Select Brand
		WebElement testDropDown = driver.findElement(By.id("audit_brand"));
		testDropDown.click();
		Select dropdown = new Select(testDropDown);
		dropdown.selectByVisibleText("C.O.D.E");
		
		  //Uploading File
        WebElement uploadElement =driver.findElement(By.id("audit_file_location"));	
        uploadElement.sendKeys("/home/josh/Documents/C-O-D-E_ATS.csv");
        Thread.sleep(5000);

        //Upload File Button
        WebElement upload= driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        upload.click();
		
        System.out.println("ATS Uploaded Successfuly");
	}
	
}
