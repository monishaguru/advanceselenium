package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LearningInvocation 
{
	@Test(invocationCount = 3,priority = -1)
	public static void launch() throws InterruptedException
		{
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.shoppersstack.com/");
			Thread.sleep(3000);
			driver.quit();
					
		}
	@Test(invocationCount = 2,priority=1)
	public static void console()
	{
		Reporter.log("testNg",true);
	}
	
}
//default value of invocationCount is 1