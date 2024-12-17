package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	@Test
	public void m1() {
		System.out.println("step 1");
		System.out.println("step 2");
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(true, false);
		soft.assertAll();
		
		System.out.println("step 3");
		System.out.println("step 4");
		
	}

}
