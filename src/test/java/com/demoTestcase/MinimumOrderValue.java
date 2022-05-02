package com.demoTestcase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MinimumOrderValue extends BrandscopeAdminLogin{
	
	@Test
	public static void verifyUserCanSetMinimumOrderValue() throws IOException, Exception
	{
		
	BrandscopeAdminLogin.setUp();
	BrandscopeAdminLogin.verifyUserLoginAsBSAdmin();
	//Go to setup tab
	WebElement setup=driver.findElement(By.xpath("(//span[contains(text(),'Setup')])[1]"));
	setup.click();
	Thread.sleep(5000);
	// Select Account & Shipping Codes
	WebElement AccountShippingCodes=driver.findElement(By.xpath("(//span[normalize-space()='Account & Shipping Codes'])[1]"));
	AccountShippingCodes.click();
	Thread.sleep(3000);
	WebElement BrandRetailerDetails=driver.findElement(By.xpath("(//a[@class='nav-link'])[1]"));
	BrandRetailerDetails.click();
	Thread.sleep(5000);
	
	//Select Brand
	Select Brand = new Select(driver.findElement(By.id("account_code_brand")));
	Brand.selectByVisibleText("C.O.D.E");
	Thread.sleep(5000);
	
	WebElement BrandRetailer=driver.findElement(By.xpath("//div[normalize-space()='BrandFactoryRetailer']"));
	BrandRetailer.click();
	Thread.sleep(3000);
	WebElement QnFMinOrder=driver.findElement(By.xpath("(//div[@role='gridcell'])[6]"));
	Actions actions = new Actions(driver);
	actions.doubleClick(QnFMinOrder).sendKeys("100").perform();
	//QnFMinOrder.clear();
	//QnFMinOrder.sendKeys("100");
	Thread.sleep(5000);
	WebElement sideClick=driver.findElement(By.xpath("(//div[@role='gridcell'])[5]"));
	sideClick.click();
	Thread.sleep(3000);
//	BrandscopeAdminLogin.tearDown();
	}
	

}
