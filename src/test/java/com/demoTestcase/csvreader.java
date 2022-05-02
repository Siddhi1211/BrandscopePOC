package com.demoTestcase;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvException;
//import com.opencsv.exceptions.CsvValidationException;
import au.com.bytecode.opencsv.CSVReader;
import io.github.bonigarcia.wdm.WebDriverManager; 
public class csvreader {
	static WebDriver driver;
    public static void main(String [] args) throws Exception, Exception
    {
        readCSVSheet();
    }
    public static void readCSVSheet() throws IOException, Exception {
     //   WebDriver driver = new ChromeDriver();      
        WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.get("https://qa-erp.brandscope.com.au/users/sign_in");
        String dir= System.getProperty("user.dir");
		String pathToFile= dir+"src/test/resources/TestDataInputFile.csv";
		
        CSVReader reader = new CSVReader(new FileReader(pathToFile));

        StringBuffer buffer = new StringBuffer();
        String data[];
        List<String[]> val=reader.readAll();

        String username=val.get(2)[0];
        System.out.println(username);
        driver.findElement(By.id("user_username")).sendKeys(username);
        String password = val.get(2)[1];
        System.out.println(password);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.xpath("//a[@id=\"profileModalLink\"]")).click();

    }

}

