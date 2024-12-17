package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt='Create Organization...']") private WebElement OrgAddSym;
	@FindBy(xpath = "//input[@name='accountname']") private WebElement accName;
	@FindBy(id = "phone") private WebElement ph;
	@FindBy(id = "email1") private WebElement em;
	@FindBy(name = "button") private WebElement save;
	
	public WebElement getOrgAddSym() {
		return OrgAddSym;
	}
	
	public WebElement getAccName() {
		return accName;
	}
	public WebElement getPh() {
		return ph;
	}
	public WebElement getEm() {
		return em;
	}
	public WebElement getSave() {
		return save;
	}
	
	public void getOrgAddSymClick() {
		OrgAddSym.click();
	}
	public void SendAccName(String orgName, String phone, String email) {
		accName.sendKeys(orgName);
		ph.sendKeys(phone);
		em.sendKeys(email);
	}
	
	public void saveBtn() {
		save.click();
	}

}
