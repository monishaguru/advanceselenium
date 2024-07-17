package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class LearningPriority 
{
	@Test(priority=1)
	public static void logout()
	{
		Reporter.log("Logged out successfully",true);
	}
	@Test(priority=-1)
	public static void login()
	{
		Reporter.log("Logged in successfully",true);
	}
	@Test(priority=0)
	public static void AddtoCart()
	{
		Reporter.log(" product added to the cart successfully",true);
	}
}
