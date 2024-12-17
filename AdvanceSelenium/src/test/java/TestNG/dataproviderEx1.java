package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderEx1 {
	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest, int numOfPpl) {
		System.out.println("Book tickets from " + src + " to " +dest +numOfPpl);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] obj = new Object[2][3];
		
		obj[0][0] = "Banglore";
		obj[0][1] = "Goa";
		obj[0][2] = 5;
		
		obj[1][0] = "Banglore";
		obj[1][1] = "Mysore";
		obj[1][2] = 7;
		return obj;
	}

}
