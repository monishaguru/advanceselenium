package PomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{	
	public ProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		@FindBy(linkText="Products")
		private WebElement productLink;
		
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createbutton;
		
		@FindBy(name="productname")
		private WebElement nametextbox;
		
		public WebElement getCreatebutton() {
			return createbutton;
		}

		public WebElement getNametextbox() {
			return nametextbox;
		}

		public WebElement getProductLink() 
		{
			return productLink;
		
	    }

}
