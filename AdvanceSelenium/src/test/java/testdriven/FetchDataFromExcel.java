package testdriven;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchDataFromExcel
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		//1) file input stream
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		
		//2) create workbook object
		Workbook wb = WorkbookFactory.create(fis);
		
		//fetching values
		System.out.println(wb.getSheet("Sheet1").getRow(0).getCell(0).getNumericCellValue());
		System.out.println(wb.getSheet("Sheet1").getRow(3).getCell(2).getStringCellValue());
		System.out.println(wb.getSheet("Sheet1").getRow(8).getCell(2).getBooleanCellValue());
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url =wb.getSheet("Sheet1").getRow(12).getCell(2).getStringCellValue();
		String UN=wb.getSheet("Sheet1").getRow(15).getCell(3).getStringCellValue();
		String pwd = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		driver.get(url);
		driver.get(UN);
		driver.get(pwd);
		driver.quit();
		
		
		
		
		
		/*Cell cell1 = wb.getSheet("Sheet1").getRow(0).getCell(0);
	    Cell cell2 = wb.getSheet("Sheet1").getRow(3).getCell(2);
	    Cell cell3 = wb.getSheet("Sheet1").getRow(8).getCell(2);
	    Cell cell4 = wb.getSheet("Sheet1").getRow(12).getCell(2);
	    Cell cell5 = wb.getSheet("Sheet1").getRow(15).getCell(3);
	    Cell cell6 = wb.getSheet("Sheet1").getRow(1).getCell(5);
	    
		
	    DataFormatter data = new DataFormatter();
	    System.out.println(data.formatCellValue(cell1));
	    System.out.println(data.formatCellValue(cell2));
	    System.out.println(data.formatCellValue(cell3));
	    System.out.println(data.formatCellValue(cell4));
	    System.out.println(data.formatCellValue(cell5));
	    System.out.println(data.formatCellValue(cell6));*/
		
	}
}
