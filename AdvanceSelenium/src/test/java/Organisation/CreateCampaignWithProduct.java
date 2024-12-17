package Organisation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Object_Repository.LoginToVtiger;
import Object_Repository.ProductCreatePage;
import Object_Repository.VtigerHomePage;

public class CreateCampaignWithProduct extends BaseClass {
	@Test
	public void createCampaignWithProduct() throws Throwable {
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickPrdLink();
		
		ProductCreatePage prd = new ProductCreatePage(driver);
		prd.clickPrdAddSym();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String PrdName = elib.readExcelData("Sheet1", 0, 0) + ranNum;
		System.out.println(PrdName);
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> it = allwin.iterator();
		while (it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
		if(title.contains("Products&action"))
		{
			break;
		}
		}
		prd.PrdNameClick(PrdName);
		prd.PrdSaveClick();
		
		//to click on "More"
		WebElement More = driver.findElement(By.linkText("More"));
				
		//To click on Campaign
		Actions act = new Actions(driver);
		act.moveToElement(More).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
				
		//To create campaign reading from excel sheet
		
		//click on product + button
		
		
		

	}

}