package scripts_vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PomRepo.OrganisationPage;
import genericlib.BaseClass;

public class Script2_Test extends BaseClass
{	

	@Test(groups="Organisation")
	public void Script2() throws EncryptedDocumentException, IOException, InterruptedException
	{
		OrganisationPage op= new OrganisationPage(driver);
		op.getOrganisationLink().click();
		op.getCreatebutton().click();
		int ranNum = ja.getRandomNumber();
		op.getNametextbox().sendKeys(um.getDataFromExcelFile("Organisation",0,0)+ranNum);
		wb.selectDropdownByValue(op.getIndustryDropdown(),"Healthcare");
		Thread.sleep(3000);
		op.getSavebutton().click();
		Thread.sleep(3000);
		
	}
}
