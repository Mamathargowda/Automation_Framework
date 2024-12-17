package Organisation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Object_Repository.ProductCreatePage;
import Object_Repository.ProductDeletePage;
import Object_Repository.ValidateProductPage;
import Object_Repository.VtigerHomePage;


public class ToCreateAndDeleteProductTest extends BaseClass{
	
	@Test
	public void CreateAndDeleteProductTest() throws Throwable {
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickPrdLink();
		
		ProductCreatePage prd = new ProductCreatePage(driver);
		prd.clickPrdAddSym();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String PrdName = elib.readExcelData("Sheet1", 0, 0) + ranNum;
		System.out.println(PrdName);
		
		prd.PrdNameClick(PrdName);
		prd.PrdSaveClick();
		
		//verification
		ValidateProductPage valPrd = new ValidateProductPage(driver);
		valPrd.productValidate(driver, PrdName);
		
		//delete product
		
		// Navigating to product table
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		//driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
		//driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+PrdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
		//driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		
		//verification
//		WebElement prd1 = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+ PrdName +"']"));
//		if(prd1.equals(PrdName))
//		{
//			System.out.println("Product Name is Present");
//		}
//		else
//		{
//			System.out.println("Product name is not Present");
//		}
		
//		WebElement admLink = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(admLink).perform();
		
		ProductDeletePage delPrd = new ProductDeletePage(driver);
		delPrd.getPrdLinkClick();
		delPrd.selectPrdName(driver, PrdName);
		
		delPrd.getDeleteBtnClick();
		driver.switchTo().alert().accept();
		
		//delPrd.validatePrdName(driver, PrdName);
		
		home.SignoutLink();
		
	}

}
