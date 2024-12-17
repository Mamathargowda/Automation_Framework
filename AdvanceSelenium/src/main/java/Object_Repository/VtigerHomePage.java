package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerHomePage {
	public VtigerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//organization home page
	@FindBy(linkText = "Organizations") private WebElement OrgLink;
	
	public WebElement getOrgLink() {
		return OrgLink;
	}
	
	public void OrgLinkClick() {
		OrgLink.click();
	}
	
	
	//Campaign Home page
	@FindBy(linkText = "More") private WebElement MoreLink;
	@FindBy(name = "Campaigns") private WebElement campLink;
	@FindBy(xpath = "//img[@title='Create Campaign...']") private WebElement CmpAddSym;
	
	public WebElement getMoreLink() {
		return MoreLink;
	}
	public WebElement getCampLink() {
		return campLink;
	}
	public WebElement getAddSymbol() {
		return CmpAddSym;
	}
	
	public void clickMoreLink() {
		MoreLink.click();
	}
	
	public void clickCampLink() {
		campLink.click();
	}
	
	public void clickAddSym() {
		CmpAddSym.click();
	}
	
	//Product Home page
	@FindBy(linkText = "Products") private WebElement prdLink;

	public WebElement getPrdLink() {
		return prdLink;
	}
	
	public void clickPrdLink() {
		prdLink.click();
	}
	
	//sign out
	@FindBy(css = "[src='themes/softed/images/user.PNG']")  private WebElement AdminLink;
	@FindBy(linkText = "Sign Out") private WebElement signout;

	public WebElement getAdminLink() {
		return AdminLink;
	}

	public WebElement getSignout() {
		return signout;
	}
	
	 public void SignoutLink() {
		 AdminLink.click();
		 signout.click();
	 }
}



	