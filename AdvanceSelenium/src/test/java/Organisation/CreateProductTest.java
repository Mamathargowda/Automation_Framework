package Organisation;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Object_Repository.ProductCreatePage;
import Object_Repository.ValidateProductPage;
import Object_Repository.VtigerHomePage;

public class CreateProductTest extends BaseClass {

	@Test
	public void createProductTest() throws Throwable {
		
		//Home POM class
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
		
		home.SignoutLink();
		driver.quit();
		
	}
}
