package code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomRepo.LoginPage;
import genericlib.ExcelUtil;
import genericlib.WebdriverUtil;

public class ScriptUsingPom
{
	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		WebdriverUtil wb = new WebdriverUtil();
		ExcelUtil ex= new ExcelUtil();
		wb.maximizeTheWindow(driver);
		wb.implicitlyWait(driver);
		driver.get(ex.getDataFromPropertyFile("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUserTextbox().sendKeys(ex.getDataFromPropertyFile("username"));
		lp.getPswdTextbox().sendKeys(ex.getDataFromPropertyFile("password"));
		lp. getLoginbtn().click();
		driver.quit();
	}
}
