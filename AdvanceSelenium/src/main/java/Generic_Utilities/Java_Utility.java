package Generic_Utilities;

import java.util.Random;

import org.openqa.selenium.By;

public class Java_Utility {
	/**
	 * This method is used to avoid duplication
	 * @author mamatha
	 * @return
	 */
	
	public int getRandomNum() {
		Random ran = new Random();
		int value = ran.nextInt(10000);
		return value;
	}
}
