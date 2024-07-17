package testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericlib.ExcelUtil;
import genericlib.WebdriverUtil;

public class Crossbrowser 
{
	WebDriver driver;
	WebdriverUtil wb= new WebdriverUtil();
	ExcelUtil ex= new ExcelUtil();
	@Parameters("browser")
	@Test
	public void launch(String bname) throws IOException
	{
		if(bname.contains("chrome"))
		{
		driver=new ChromeDriver();
		wb.maximizeTheWindow(driver);
		driver.get(ex.getDataFromPropertyFile("url"));
		}
	
		else if(bname.contains("firefox"))
		{
			driver=new FirefoxDriver();
			wb.maximizeTheWindow(driver);
			driver.get(ex.getDataFromPropertyFile("url"));
		}
		else if(bname.contains("edge"))
		{
			driver=new EdgeDriver();
			wb.maximizeTheWindow(driver);
			driver.get(ex.getDataFromPropertyFile("url"));
		}
	}
		
}
