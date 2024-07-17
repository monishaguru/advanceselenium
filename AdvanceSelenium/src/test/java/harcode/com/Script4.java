package harcode.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Script4
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata1.properties");
		Properties p = new Properties();
		p.load(fis);
	    String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String data = wb.getSheet("Contact").getRow(0).getCell(0).toString();
		driver.findElement(By.name("lastname")).sendKeys(data);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Thread.sleep(2000);
		String parentId = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		ids.remove(parentId);
		for(String i:ids) {
			driver.switchTo().window(i);
			driver.findElement(By.id("search_txt")).sendKeys("puma");
			WebElement dropdown = driver.findElement(By.name("search_field"));
			Select sel= new Select(dropdown);
			sel.selectByVisibleText("Organization Name");
			driver.findElement(By.linkText("puma")).click();
			break;
		}
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		driver.quit();
		
		
		
	}
}
