package com.demoTestcase;

import java.util.Iterator;
import java.util.Set;

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

public class SupplierOrderSubmisionFlow {
	

	static WebDriver driver;
	@BeforeTest
	static void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qa-erp.brandscope.com.au/users/sign_in");
		driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	static void verifyUserLoginAsSupplier() throws InterruptedException
	{
		//verifyUserLoginAsRetailer();
		driver.findElement(By.cssSelector("input#user_username")).sendKeys("SupplyChainsUser1");
		driver.findElement(By.cssSelector("input#user_password")).sendKeys("Siddhi@12");
		driver.findElement(By.cssSelector("input.btn-primary")).click();
		//Click on Existing Buyplan to confirm order 
		WebElement Buyplan=driver.findElement(By.xpath("(//i[@aria-hidden='true'])[1]"));
		Buyplan.click();
		//Select latest BP
		Thread.sleep(5000);
		WebElement PickBP= driver.findElement(By.xpath("(//span[@ref='eValue'])[1]"));
		PickBP.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@title='Edit'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button)[4]")).click();
	}
//	@Test(priority=0)
	static void verifyUserLoginAsRetailer() throws InterruptedException
	{
		
		//driver.findElement(By.cssSelector("a#w-node-_7901208a-7799-8dd0-0aed-81f88b308563-b32f4091")).click();
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
               driver.findElement(By.xpath("//input[@class=\"sc-jTzLTM jQolZv\"]")).clear();
               driver.findElement(By.xpath("//input[@class=\"sc-jTzLTM jQolZv\"]")).sendKeys("20");

               driver.findElement(By.xpath("//button[@class=\"close\" and @aria-label=\"Close\"]")).click();
        }
	}
	@AfterTest
	static void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
