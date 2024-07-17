package testdriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class FetchDataUsingMap
{
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet Sheet = wb.getSheet("Sheet5");
		int row = Sheet.getLastRowNum();
		System.out.println(row);
		
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		for(int i=0; i<=row ;i++)
		{
			String key = Sheet.getRow(i).getCell(0).toString();
			String value = Sheet.getRow(i).getCell(1).toString();
			map.put(key, value);
		}
		for(Entry<String, String> m:map.entrySet())
		{
			System.out.println(m.getKey()+":"+m.getValue());
		}
	}
}
//Entry is the combination of key and value