package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	@Test
	public void m1() {
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(true, false);
		System.out.println("step 3");
	}
	
	@Test
	public void m2() {
		int a = 1;
		int b = 1;
		Assert.assertEquals(a, b, "Not equal");
		System.out.println("it is equal");
	}
	
	@Test
	public void m3() {
		int a = 1;
		int b = 1;
		Assert.assertNotEquals(a, b, "It is equal");
		System.out.println("Not equal");
	}
	
	@Test
	public void m4() {
		String s1 = "Mamatha";
		String s2 = "Mamtha";
		Assert.assertTrue(s1.equalsIgnoreCase(s2), "False");
		System.out.println("It is equal");
	}
	
	@Test
	public void m5() {
		String s = null;
		Assert.assertNull(s, "it is not null");
		System.out.println("it is null");
	}
}
