package harcode.com;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericlib.ExcelUtil;
import genericlib.WebdriverUtil;

public class Script6 
{
	public static void main(String[] args) throws IOException, InterruptedException  
	{
		WebdriverUtil wb=new WebdriverUtil();
		ExcelUtil ex = new ExcelUtil();
		WebDriver driver = new ChromeDriver();
		//wb.maximizeTheWindow(driver); (When you are calling non static method)
		WebdriverUtil.maximizeTheWindow(driver);
		wb.implicitlyWait(driver);
		driver.get(ex.getDataFromPropertyFile("url"));
		driver.findElement(By.name("user_name")).sendKeys(ex.getDataFromPropertyFile("username"));
		 Thread.sleep(3000);
		 driver.findElement(By.name("user_password")).sendKeys(ex.getDataFromPropertyFile("password"));
		 Thread.sleep(3000);
		 driver.findElement(By.id("submitButton")).click();
		WebElement searchbox = driver.findElement(By.name("query_string"));
		searchbox.sendKeys("contacts");
		wb.refreshThePage(driver);
		Thread.sleep(3000);
		searchbox.sendKeys("contacts");
		
		 
	}
}
