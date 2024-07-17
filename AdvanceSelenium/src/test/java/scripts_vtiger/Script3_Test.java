package scripts_vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import PomRepo.Campaign;
import PomRepo.ContactPage;
import PomRepo.OrganisationPage;
import genericlib.BaseClass;

public class Script3_Test extends BaseClass{

	@Test(groups="Campaign")
	public void script3() throws EncryptedDocumentException, IOException 
	{
		Campaign cp= new Campaign(driver);
		cp.getMoreoptions().click();
		cp.getCampaign().click();
		cp.getCreateButton().click();
		cp.getNametextBox().sendKeys(um.getDataFromExcelFile("campaign", 0, 0));
		OrganisationPage op = new OrganisationPage(driver);
		op.getSavebutton().click();
		
	}
}