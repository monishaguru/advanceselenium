package scripts_vtiger;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PomRepo.OrganisationPage;
import genericlib.BaseClass;
import static org.testng.Assert.assertEquals;

public class Script1_Test extends BaseClass
{	

	@Test(groups="Organisation")
	public void Script1() throws EncryptedDocumentException, IOException, InterruptedException
	{
		OrganisationPage op= new OrganisationPage(driver);
		Thread.sleep(3000);
		op.getOrganisationLink().click();
		//assertEquals(driver.getTitle(),op.getOrganisationtext());
		op.getCreatebutton().click();
		//assertEquals(op.getCreateorganizationText().isDisplayed(),true,"not displayed the text");
		int ranNum = ja.getRandomNumber();
		String data =um.getDataFromExcelFile("Organisation",0,0)+ranNum;
		WebElement ele= op.getNametextbox();
		ele.sendKeys(um.getDataFromExcelFile("Organisation",0,0)+ranNum);
		//assertEquals(ele.getAttribute("value"),data,"data are not matching");
		op.getSavebutton().click();
		//assertEquals(driver.getTitle(),op.getSavebutton(),"not matching");
		Thread.sleep(3000);
		
	}

	
	
}
