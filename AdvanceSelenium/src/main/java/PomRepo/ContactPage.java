package PomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactLink;
	
	@FindBy(name="lastname")
	private WebElement LastnameTextbox;
	
	public WebElement getCreateContactLink() {
		return createContactLink;
	}


	public WebElement getLastnameTextbox() {
		return LastnameTextbox;
	}

	
	public WebElement getContactlink() {
		return contactlink;
	}
	
	
}
