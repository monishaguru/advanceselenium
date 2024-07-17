package testng;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviders
{
	@DataProvider
	public String[][] getdata()
	{
		String[][]data=new String[2][3];
		data[0][0]="moni";
		data[0][1]="A+";
		data[0][2]="chennai";
		Reporter.log("**************",true);
		data[1][0]="deeban";
		data[1][1]="A+";
		data[1][2]="chennai";
		return data;
	}
	
	@Test(dataProvider="getdata")
	public void details(String name,String bloodgroup,String place)
	{
		Reporter.log(name,true);
		Reporter.log(bloodgroup,true);
		Reporter.log(place,true);
		
		
	}
}
