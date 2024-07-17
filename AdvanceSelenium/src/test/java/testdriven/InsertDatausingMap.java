package testdriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDatausingMap 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =  new FileInputStream("./src/test/resources/ExcelData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		Sheet Sheet = wb.getSheet("Sheet6");
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("monisha", "G");
		map.put("Deeban Kumar", "R");
		map.put("SuryaVarman", "U.G");
		map.put("Togo", "G");
		int rowno = 0;
		for(Entry<String, String>m:map.entrySet())
		{
			Row row = Sheet.createRow(rowno++);
			
			row.createCell(0).setCellValue((String)m.getKey());
			row.createCell(1).setCellValue((String)m.getValue());
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/ExcelData.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("data entered");
	}
}
