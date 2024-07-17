package testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PomRepo.LoginPage;
import PomRepo.OrganisationPage;
import genericlib.ExcelUtil;



public class MultipleDataProvider
{
	@DataProvider
	public String[][] testdata() throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis= new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowNum = sheet.getPhysicalNumberOfRows();
		int ColNum = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data= new String[rowNum][ColNum];
		for(int i=0;i<rowNum;i++)
		{
			for(int j=0;j<ColNum;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).toString();
			}
				
		}
		return data;
	}
	
	@Test(dataProvider="testdata")
	public void details(String[] testdata) throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		ExcelUtil ex= new ExcelUtil();
		driver.get(ex.getDataFromPropertyFile("url"));
		LoginPage lp= new LoginPage(driver);
		lp.getUserTextbox().sendKeys(ex.getDataFromPropertyFile("username"));
		lp.getPswdTextbox().sendKeys(ex.getDataFromPropertyFile("password"));
		lp.getLoginbtn().click();
		OrganisationPage op= new OrganisationPage(driver);
		op.getOrganisationLink().click();
		op.getCreatebutton().click();
		op.getNametextbox().sendKeys(testdata[0]);
		Thread.sleep(3000);
		op.getPhonenumberTF().sendKeys(testdata[1]);
		Thread.sleep(3000);
		op.getEmailTextField().sendKeys(testdata[2]);
		Thread.sleep(3000);	
		lp.getAdminbutton().click();
		lp.getLogoutbutton().click();
		
	}
}
