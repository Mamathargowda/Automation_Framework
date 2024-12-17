package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Object_Repository.LoginToVtiger;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite
	public void bs() {
		System.out.println("database connection");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("parallel execution");
	}
	
	@BeforeClass
    public void bc() throws Throwable {
		File_Utility flib = new File_Utility();
		String BROWSER_NAME = flib.getKeyAndValue("browser"); //System.getProperty("browser");

		if (BROWSER_NAME.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER_NAME.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER_NAME.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
    	System.out.println("launching browser");
    	sdriver=driver;
    }
    
	@BeforeMethod
    public void bm() throws Throwable {
		File_Utility flib = new File_Utility();
		String URL_Link = flib.getKeyAndValue("url"); //System.getProperty("url");
		String USER_NAME =flib.getKeyAndValue("uname");//System.getProperty("uname");
		String PASSWORD = flib.getKeyAndValue("pwd");//System.getProperty("pwd");
		driver.get(URL_Link);
		
		LoginToVtiger login = new LoginToVtiger(driver);
		login.loginIntoVtiger(USER_NAME, PASSWORD);
		
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
    	System.out.println("login to application");
    }
    
	@AfterMethod
    public void af() {
    	System.out.println("logout from application");
    }
	
	@AfterClass
	public void ac() {
		System.out.println("closing the browser");
	}
	
	@AfterTest
	public void at() {
		System.out.println("stops the execution");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("close database");
	}
}
