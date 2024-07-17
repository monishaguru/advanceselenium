package PomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage
{
	
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public WebElement getOrganisationLink() {
		return OrganisationLink;
	}

	public WebElement getNametextbox() {
		return nametextbox;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getGroupradiobutton() {
		return groupradiobutton;
	}

	
	public WebElement getCreatebutton() {
		return Createbutton;
	}
	public WebElement getPhonenumberTF() {
		return phonenumberTF;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}
	
	public WebElement getOrganisationtext() {
		return organisationtext;
	}

	public WebElement getCreateorganizationText() {
		return createorganizationText;
	}
	
	@FindBy(linkText ="Organizations")
	private WebElement OrganisationLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Createbutton;

	@FindBy(name="accountname")
	private WebElement nametextbox;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(name="assigntype")
	private WebElement groupradiobutton;
	
	@FindBy(id="phone")
	private WebElement phonenumberTF;
	
	@FindBy(id="email1")
	private WebElement emailTextField;
	
	@FindBy(linkText="Organizations")
	private WebElement organisationtext;
	
	@FindBy(xpath = "//span[text()='Creating New Organization']")
	private WebElement createorganizationText;
}
	
	
	
	