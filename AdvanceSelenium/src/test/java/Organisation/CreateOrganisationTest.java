package Organisation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Webdriver_Utility;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.OrganizationValidatePage;
import Object_Repository.VtigerHomePage;

//@Listeners(Generic_Utilities.ExtentReport.class)
public class CreateOrganisationTest extends BaseClass {
	@Test
	public void createOrganizationTest() throws Throwable {
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String orgName = elib.readExcelData("Sheet3", 0, 0)+ranNum;
		
		String ph = elib.readFormattedExcelData("Sheet3", 1, 0);
		
		String email = elib.readFormattedExcelData("Sheet3", 2, 0);
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.OrgLinkClick();
		
		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.getOrgAddSymClick();
		orgPage.SendAccName(orgName, ph, email);
		orgPage.saveBtn();
		
		//Assert.fail();
		
		OrganizationValidatePage org = new OrganizationValidatePage(driver);
		String actName = org.OrgValidate(driver, orgName);
		Assert.assertEquals(actName, orgName);
		System.out.println("Orgnaization is created" +actName);
		
		home.SignoutLink();
		driver.quit();
	}

}
