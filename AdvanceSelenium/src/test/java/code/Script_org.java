package code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomRepo.LoginPage;
import PomRepo.OrganisationPage;
import genericlib.ExcelUtil;
import genericlib.JavaUtil;
import genericlib.WebdriverUtil;

public class Script_org
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
		OrganisationPage op= new OrganisationPage(driver);
		op.getOrganisationLink().click();
		op.getCreatebutton().click();
		Thread.sleep(3000);
		JavaUtil jv= new JavaUtil();
		int num = jv.getRandomNumber();
		op.getNametextbox().sendKeys(ex.getDataFromExcelFile("Organisation", 0, 0)+num);
		Thread.sleep(3000);
		wb.selectDropdownByValue(op.getIndustryDropdown(), "Healthcare");
		Thread.sleep(2000);		
		op.getSavebutton().click();
		driver.quit();
		
		
	}
}
