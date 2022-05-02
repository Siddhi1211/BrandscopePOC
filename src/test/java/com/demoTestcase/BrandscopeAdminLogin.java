package com.demoTestcase;

import static org.testng.Assert.assertEquals;

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
	
	//@Test 
	static void verifyUserLoginAsBSAdmin() throws InterruptedException
	{
		//driver.findElement(By.cssSelector("a#w-node-_7901208a-7799-8dd0-0aed-81f88b308563-b32f4091")).click();
		driver.findElement(By.cssSelector("input#user_username")).sendKeys("josh.brandscope1@gmail.com");
		driver.findElement(By.cssSelector("input#user_password")).sendKeys("josh$123#");
		driver.findElement(By.cssSelector("input.btn-primary")).click();
		String ActualUrl= driver.getCurrentUrl();
		System.out.println(ActualUrl);
	}
	
	//@Test 
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
	
//	@Test
	void verifyUserLoginAsRetailer() throws InterruptedException
	{
		
		driver.findElement(By.cssSelector("a#w-node-_7901208a-7799-8dd0-0aed-81f88b308563-b32f4091")).click();
		driver.findElement(By.cssSelector("input#user_username")).sendKeys("brandfactoryuser");
		driver.findElement(By.cssSelector("input#user_password")).sendKeys("Siddhi@12");
		driver.findElement(By.cssSelector("input.btn-primary")).click();
		
		driver.findElement(By.xpath("(//span[contains(text(),'Brands')])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='#brandModal'] //span[contains(text(),'C.O.D.E')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id=\"quickFillLink\"]")).click();
		Thread.sleep(5000);
		 //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.xpath("//div[@class=\"sc-hEsumM ccQYdY caption w-100 mb-4 img-fluid\"]"));
                System.out.println("Heading of child window is " + text.getText()); 
                Thread.sleep(3000);
            }
              // driver.findElement(By.xpath("(//div[@class=\"like \"] //img[@src=\"/like_button_off.png\"])[1]")).click();
              // jse.executeScript("window.scrollBy(0,250)");
               //driver.findElement(By.xpath("//a[@href=\"/brands/255/products/397881/quick-view?buyplanId=427064&defaultTab=2&buyplanItemId=null\"]")).click();
              driver.findElement(By.xpath("(//div[@class=\"sc-eqIVtm fUahYx item-info\"] /div[@class=\"item-quantity release-product\"])[3]")).click();
              
               Thread.sleep(3000); 
               driver.findElement(By.linkText("Qty Grid")).click();
               driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[2]")).clear();
               driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[2]")).sendKeys("10");

               driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[3]")).clear();
               driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[3]")).sendKeys("10");

               
               driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[4]")).clear();
               driver.findElement(By.xpath("(//input[@class=\"sc-jTzLTM jQolZv\"])[4]")).sendKeys("10");

               driver.findElement(By.xpath("//button[@class=\"close\" and @aria-label=\"Close\"]")).click();
        
               driver.findElement(By.xpath("//button[@class=\"sc-jWBwVP giYJan btn btn-success\"]")).click();
               //driver.findElement(By.id("terms_and_conditions")).click();
               //driver.findElement(By.xpath("(//label[@for='terms_and_conditions'])[1]")).click();
               Thread.sleep(3000);
               JavascriptExecutor jse = (JavascriptExecutor)driver;
               WebElement element = driver.findElement(By.id("terms_and_conditions"));
               JavascriptExecutor executor = (JavascriptExecutor)driver;
               executor.executeScript("arguments[0].click();", element);
              
               Thread.sleep(3000);
               driver.findElement(By.xpath("//button[@class=\"btn btn-primary rounded\"]")).click();
               System.out.println("Order Placed Successfully");
        
        }
	}
	@AfterTest
	static void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
