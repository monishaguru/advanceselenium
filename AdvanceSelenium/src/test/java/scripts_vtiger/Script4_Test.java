package scripts_vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import PomRepo.ContactPage;
import PomRepo.OrganisationPage;
import genericlib.BaseClass;

public class Script4_Test extends BaseClass
{
	@Test(groups="contact")
	public void Script4() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ContactPage op= new ContactPage(driver);
		op.getContactlink().click();
		op.getCreateContactLink().click();
		op.getLastnameTextbox().sendKeys(um.getDataFromExcelFile("Contact", 0, 0));
		OrganisationPage op1 = new OrganisationPage(driver);
		op1.getSavebutton().click();
		
	}
}
