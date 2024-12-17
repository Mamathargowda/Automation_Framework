package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Webdriver_Utility {
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void onTestFailure(ITestResult result) {

		TakesScreenshot takesSceenShot = (TakesScreenshot) BaseClass.sdriver;
		
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./FailedScripts.png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {

			e.printStackTrace();
		}
	} 
	
public static String takeScreenShot1(WebDriver driver, String screenShotName) throws Throwable {
		
		TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName +".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
}