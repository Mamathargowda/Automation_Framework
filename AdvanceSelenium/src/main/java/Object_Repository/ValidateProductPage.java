package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateProductPage {
	public ValidateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void productValidate(WebDriver driver, String PrdName) {
	
	String product = driver.findElement(By.id("dtlview_Product Name")).getText();
	if(product.contains(PrdName)) {
		System.out.println("Product is created" +product);
	}
	else
		System.out.println("Product is not created");
	}

}
