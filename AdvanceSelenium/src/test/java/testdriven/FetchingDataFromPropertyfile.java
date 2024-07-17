package testdriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromPropertyfile 
{
	public static void main(String[] args) throws IOException
	{
		//1) create file input stream object
	     FileInputStream file = new FileInputStream("./src/test/resources/prop.properties");
	     FileInputStream file1 = new FileInputStream("./src/test/resources/prop1.properties");
	     
	     
	     //2)create a prop file object
	     Properties p = new Properties();
	    
	     
	     //3)load file
	     p.load(file);
	     p.load(file1);
	     
	     //4) fetch the data
	     System.out.println(p.getProperty("url"));
	     System.out.println(p.getProperty("sample"));
	     System.out.println(p.getProperty("email"));
	     System.out.println(p.getProperty("pwd"));
	     
	     WebDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
	    // String url = p.getProperty("url");
	   //  driver.get(url);
	     driver.get(p.getProperty("url"));
	     driver.quit();
	}
}
