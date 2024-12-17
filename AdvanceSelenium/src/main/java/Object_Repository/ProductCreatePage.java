package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreatePage {
	public ProductCreatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt='Create Product...']") private WebElement PrdAddSym;
	@FindBy(name = "productname") private WebElement PrdName;
	@FindBy(name = "button") private WebElement PrdSave;
	
	public WebElement getPrdName() {
		return PrdName;
	}

	public WebElement getPrdSave() {
		return PrdSave;
	}

	public WebElement getPrdAddSym() {
		return PrdAddSym;
	}
	
	public void clickPrdAddSym() {
		PrdAddSym.click();
	}
	
	public void PrdNameClick(String prdName) {
		PrdName.sendKeys(prdName);
	}
	
	public void PrdSaveClick() {
		PrdSave.click();
	}
	
	//delete product
	//@FindBy()

}
