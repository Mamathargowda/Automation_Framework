package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrganizationValidatePage {
	
	public OrganizationValidatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String OrgValidate(WebDriver driver, String OrgName) {
		String actData = driver.findElement(By.id("dtlview_Organization Name")).getText();
//		if (actData.contains(OrgName)) {
//			System.out.println("Organization name is created" + OrgName);
//			}
//		else {
//			System.out.println("Organization name is not created");
//		}
		return actData;
	}

}
