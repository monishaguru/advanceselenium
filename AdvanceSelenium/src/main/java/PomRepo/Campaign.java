package PomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign 
{
	public Campaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains (text(),'More')]")
	private WebElement moreoptions;
	
	@FindBy(name="Campaigns")
	private WebElement campaign;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateButton;
	
	@FindBy(name="campaignname")
	private WebElement nametextBox;
	
	@FindBy(xpath ="//input[@class='crmButton small save']")
	private WebElement saveButton;

	public WebElement getMoreoptions() {
		return moreoptions;
	}

	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getCreateButton() {
		return CreateButton;
	}

	public WebElement getNametextBox() {
		return nametextBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
}
