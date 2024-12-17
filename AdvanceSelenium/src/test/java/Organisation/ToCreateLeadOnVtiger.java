package Organisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;

public class ToCreateLeadOnVtiger {

	public static void main(String[] args) throws Throwable {
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String UNAME =flib.getKeyAndValue("uname");
		String PWD = flib.getKeyAndValue("pwd");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.cssSelector("[alt='Create Lead...']")).click();
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/example.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		
		WebElement NameDrpDwn = driver.findElement(By.name("salutationtype"));
		Select select = new Select(NameDrpDwn);
		select.selectByIndex(2);
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String LFirstName = elib.readExcelData("Sheet4", 0, 0)+ranNum;
		String LLastName = elib.readExcelData("Sheet4", 1, 0)+ranNum;
		String LCompName = elib.readExcelData("Sheet4", 2, 0)+ranNum;

		
		driver.findElement(By.name("firstname")).sendKeys(LFirstName);
		driver.findElement(By.name("lastname")).sendKeys(LLastName);
		driver.findElement(By.name("company")).sendKeys(LCompName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}

}
