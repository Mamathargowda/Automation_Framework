package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreateNavigationPage {
	
	public CampaignCreateNavigationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname") private WebElement campname;
	@FindBy(xpath= "//input[@title='Save [Alt+S]']") private WebElement savebutton;
	
	public WebElement getCampname() {
		return campname;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	
    public void sendCampName(String CampName) {
    	campname.sendKeys(CampName);
    }
    
    public void saveButton() {
    	savebutton.click();
    }
}
