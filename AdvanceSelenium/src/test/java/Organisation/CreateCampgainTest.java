package Organisation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Object_Repository.CampaignCreateNavigationPage;
import Object_Repository.CampaignValidationPage;
import Object_Repository.VtigerHomePage;

//@Listeners(Generic_Utilities.Listerner1.class)
public class CreateCampgainTest extends BaseClass{

	@Test
	public void createCampaign() throws Throwable {
		
		//to click on "More"
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();
		home.clickAddSym();
		
		//To click on Campaign
		//Actions act = new Actions(driver);
		//act.moveToElement(More).perform();
		//driver.findElement(By.name("Campaigns")).click();
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		//To create campaign reading from excel sheet
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		Excel_Utility elib= new Excel_Utility();
		String CampData = elib.readExcelData("Campaign", 0, 0)+ranNum;
		
		CampaignCreateNavigationPage camp = new CampaignCreateNavigationPage(driver);
		camp.sendCampName(CampData);
		camp.saveButton();
		
		//Assert.fail();
		CampaignValidationPage campval = new CampaignValidationPage(driver);
		campval.CampValidate(driver, CampData);
		
		//sign out
		home.SignoutLink();
		driver.quit();
	}
		
}
