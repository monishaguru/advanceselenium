package testdriven;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDataInProperty 
{
	public static void main(String[] args) throws IOException
	{
		Properties p = new Properties();
		p.setProperty("url","https://www.fireflink.com/");
		p.setProperty("user_name","Monisha");
		p.setProperty("password", "12345");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/prop2.properties");
		p.store(fos,"prop2");
		System.out.println("value is inserted");
		
	}
}
