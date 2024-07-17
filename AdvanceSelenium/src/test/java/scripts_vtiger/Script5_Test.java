package scripts_vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import PomRepo.ProductPage;
import genericlib.BaseClass;

public class Script5_Test extends BaseClass
{
	@Test(groups="product")
	public void Script5 () throws EncryptedDocumentException, IOException
	{
		 ProductPage pp= new  ProductPage(driver);
		 pp.getProductLink().click();
		 pp.getCreatebutton().click();
		 pp.getNametextbox().sendKeys(um.getDataFromExcelDF("product", 0, 0));
		 
	}
}
