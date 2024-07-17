package genericlib;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PomRepo.LoginPage;
@Listeners(ListenersImplementation.class)
public class BaseClass
	{
		public  WebDriver driver;
		public static WebdriverUtil wb= new WebdriverUtil();
		public static ExcelUtil um= new ExcelUtil();
		//LoginPage lp= new LoginPage(driver);	
		public static JavaUtil ja= new JavaUtil();
		public static ExtentSparkReporter reporter;
		public static ExtentReports reports;
		public static  ExtentTest test;
		
		@BeforeSuite(alwaysRun=true)
		public void beforeSuite() {
			Reporter.log("Report generation",true);
			reporter= new ExtentSparkReporter(IConstant.reportpath);
			reports= new ExtentReports();
			reports.attachReporter(reporter);
		}
		@BeforeClass(alwaysRun=true)
		public void beforeClass() throws IOException {
			driver=new ChromeDriver();
			wb.maximizeTheWindow(driver);
			wb.implicitlyWait(driver);
			driver.get(um.getDataFromPropertyFile("url"));
		}
		
		@BeforeMethod(alwaysRun=true)
		public void beforeMethod(Method method) throws IOException {
			test= reports.createTest(method.getName());
			LoginPage lp=new LoginPage(driver);
			lp.getUserTextbox().sendKeys(um.getDataFromPropertyFile("username"));
			lp.getPswdTextbox().sendKeys(um.getDataFromPropertyFile("password"));
			lp.getLoginbtn().click();
		}
		
		@AfterMethod(alwaysRun=true)
		public void afterMethod() {
			LoginPage lp= new LoginPage(driver);
			lp.getAdminbutton().click();
		    lp.getLogoutbutton().click();
		}
		
		@AfterClass(alwaysRun=true)
		public void afterClass() {
			wb.ClosetheBrowser(driver);
		}
		
		@AfterSuite(alwaysRun=true)
		public void afterSuite() {
			Reporter.log("Report",true);
			reports.flush();
		}
	}






//(alwaysRun=true)---->it will help to run the script in all situtation

	