package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderEx2 {
	
	@Test(dataProvider = "readData")
	
	public void createOrganization(String name, String ph, String email) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(ph);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.name("button")).click();
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] readData() throws Throwable {
		
		Random ran = new Random();
		int ranNum = ran.nextInt();
		
		FileInputStream file = new FileInputStream("./src/test/resources/example.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		
		Sheet sh = wb.getSheet("Dataprovider");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(0);
		String excelData = cell.getStringCellValue();
		
		Row row1 = sh.getRow(1);
		Cell cell1 = row.getCell(0);
		String excelData1 = cell.getStringCellValue();
		
		Row row2 = sh.getRow(2);
		Cell cell2 = row.getCell(0);
		String excelData2 = cell.getStringCellValue();
		
		Object[][] obj = new Object[3][3];
		
		obj[0][0] = excelData + ranNum;
		obj[0][1] = "987456123";
		obj[0][2] = "abc@gmail.com";
		
		obj[1][0] = "BBB" + ranNum;
		obj[1][1] = "987457123";
		obj[1][2] = "abc1@gmail.com";
		
		obj[2][0] = "CCC" + ranNum;
		obj[2][1] = "987458123";
		obj[2][2] = "abc2@gmail.com";
		return obj;
		
	}

}
