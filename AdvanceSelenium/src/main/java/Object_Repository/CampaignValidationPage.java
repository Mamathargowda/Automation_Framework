package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampaignValidationPage {
	public CampaignValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void CampValidate(WebDriver driver, String CampData) {
	String CampName = driver.findElement(By.id("dtlview_Campaign Name")).getText();
	if(CampData.contains(CampName)) {
		System.out.println("Campaign is created"+" "+CampName);
	}
	else
		System.out.println("Campaign not created");
	}

}
