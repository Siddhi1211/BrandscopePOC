package com.demoTestcase;
/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileReader;
import  java.util.zip.ZipException;

public class ExcelFilesheetDataRead {
		public static void main (String [] args) throws IOException{
		
		//Path of the excel file
		FileInputStream fs = new FileInputStream("/home/josh/eclipse-workspace/BrandscopePOC/src/TestDataInputFile.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(1);
		System.out.println(sheet.getRow(0).getCell(1));
		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.getCell(1);
		System.out.println(sheet.getRow(1).getCell(0));
		Row row3 = sheet.getRow(1);
		Cell cell3 = row3.getCell(1);
		System.out.println(sheet.getRow(1).getCell(1));
		String cellval = cell.getStringCellValue();
		System.out.println(cellval);
		
		}		
}
*/
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelFilesheetDataRead {
  public static void main(String[] args) {
    try {
      String filePath="/home/josh/eclipse-workspace/BrandscopePOC/src/TestDataInputFile.xlsx";
      File file = new File(filePath);
      //creating a new file instance  
      FileInputStream fis = new FileInputStream(file);
      //obtaining bytes from the file  
      //creating Workbook instance that refers to .xlsx file  
      XSSFWorkbook wb = new XSSFWorkbook(fis);
      XSSFSheet sheet = wb.getSheetAt(0);
      //creating a Sheet object to retrieve object  
      Iterator < Row > itr = sheet.iterator();
      //iterating over excel file
      System.out.println("File:");
      while (itr.hasNext()) {
        Row row = itr.next();
        Iterator < Cell > cellIterator = row.cellIterator();
        //iterating over each column  
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          switch (cell.getCellType()) {
          case STRING:
            //field that represents string cell type  
            System.out.print(cell.getStringCellValue() + "\t\t\t");
            break;
          case NUMERIC:
            //field that represents number cell type  
            System.out.print(cell.getNumericCellValue() + "\t\t\t");
            break;
          default:
          }
        }
        System.out.println("");
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}

