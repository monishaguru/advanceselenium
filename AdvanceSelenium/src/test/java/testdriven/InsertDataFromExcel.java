package testdriven;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataFromExcel
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("Sheet2").createRow(0).createCell(0).setCellValue("Monisha");
		wb.getSheet("Sheet1").createRow(0).createCell(0).setCellValue("Deeban");//any data already present in that particular row..it will override.
		wb.getSheet("Sheet1").createRow(3).createCell(2).setCellValue("DeebanKumar");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/ExcelData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
		
		