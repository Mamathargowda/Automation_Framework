package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDeletePage {
	
	public ProductDeletePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Products']") private WebElement PrdLink;
	@FindBy(xpath = "//input[@value='Delete']") private WebElement DeleteBtn;
	
	
	public WebElement getPrdLink() {
		return PrdLink;
	}


	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}


	public void selectPrdName(WebDriver driver, String PrdName) {
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+PrdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}
	
	
	public void getPrdLinkClick() {
		PrdLink.click();
	}
	
	public void getDeleteBtnClick() {
		DeleteBtn.click();
	}
	
	public void validatePrdName(WebDriver driver, String PrdName) {
		WebElement prd = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+ PrdName +"']"));
		if(prd.equals(PrdName))
		{
			System.out.println("Product Name is Present"+PrdName);
		}
		else
		{
			System.out.println("Product name is not Present" +PrdName);
		}
	}

}
