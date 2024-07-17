package code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomRepo.Campaign;
import PomRepo.LoginPage;
import PomRepo.OrganisationPage;
import genericlib.ExcelUtil;
import genericlib.JavaUtil;
import genericlib.WebdriverUtil;

public class Script_Campaign
{
	public static void main(String[] args) throws IOException, InterruptedException 
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
		Thread.sleep(3000);
		Campaign cm= new Campaign(driver);
		cm.getMoreoptions().click();
		cm.getCampaign().click();
		Thread.sleep(3000);
		cm.getCreateButton().click();
		cm.getNametextBox().sendKeys(ex.getDataFromExcelFile("campaign", 0, 0));
		Thread.sleep(3000);
		cm.getSaveButton().click();
		Thread.sleep(2000);
		driver.quit();
	
	}
}
