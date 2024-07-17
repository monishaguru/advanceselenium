package testdriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class FetchMultipleDataExcel 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet Sheet = wb.getSheet("Sheet3");
		int RowNum = Sheet.getPhysicalNumberOfRows();
		int ColNum = Sheet.getRow(0).getPhysicalNumberOfCells();
		for(int i =0; i<RowNum; i++)
		{
			for(int j=0; j<ColNum; j++)
			{
				  Cell data = Sheet.getRow(i).getCell(j);
				  DataFormatter datas = new DataFormatter();
				  System.out.println(datas.formatCellValue(data));
			}
		}
	}
}

//we have to give the data in excel sheet in the form of close matrix only.