package PomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement userTextbox;
	
	@FindBy(name="user_password")
	private WebElement pswdTextbox;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminbutton;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logoutbutton;

	public WebElement getAdminbutton() {
		return adminbutton;
	}

	public WebElement getLogoutbutton() {
		return logoutbutton;
	}

	
	public WebElement getUserTextbox() {
		return userTextbox;
	}

	public WebElement getPswdTextbox() {
		return pswdTextbox;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	
	
}
