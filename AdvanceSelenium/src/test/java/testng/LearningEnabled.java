package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LearningEnabled 
{
	@Test(enabled=true)
	public static void launch() throws InterruptedException
		{
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.shoppersstack.com/");
			Thread.sleep(3000);
			driver.quit();
					
		}
	@Test(enabled=false)
	public static void console()
	{
		Reporter.log("testNg",true);
	}
	
}


//default value of enabled is true.
