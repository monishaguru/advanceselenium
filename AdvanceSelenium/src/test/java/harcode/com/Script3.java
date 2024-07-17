package harcode.com;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Script3 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata1.properties");
		 Properties p = new Properties();
		  p.load(fis);
		 String url = p.getProperty("url");
		 String username = p.getProperty("username");
		String password = p.getProperty("password");
		  WebDriver driver =new ChromeDriver();
		  driver.manage().window().maximize();
		 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  Thread.sleep(2000);
		  driver.get(url);
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 Thread.sleep(3000);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 Thread.sleep(3000);
		 driver.findElement(By.id("submitButton")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 Random raNum = new Random();
		Object num = raNum.nextInt(100);
		 FileInputStream fis1=new FileInputStream("./src/test/resources/Script2.xlsx");
		 Workbook wb = WorkbookFactory.create(fis1);
		Sheet Sheet = wb.getSheet("Organisation");
		Row row = Sheet.getRow(0);
		 Cell cell = row.getCell(0);
		 String data = cell.getStringCellValue()+num;
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data);
	    WebElement dropdown = driver.findElement(By.name("industry"));
		 Select sel = new Select(dropdown);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(3000);
		driver.quit();		
		
		
		 
		 
		  
	}
}
