package Practise;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToPrintAllAutoSuggestions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.bigbasket.com");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("apples");
		List<WebElement> apples = driver.findElements(By.xpath("//span[@class='Label-sc-15v1nk5-0 QuickSearch___StyledLabel2-sc-rtz2vl-7 gJxZPQ gFDEBU']"));
		for(WebElement apple: apples) {
			String applename = apple.getText();
			System.out.println(applename);
		}
		
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='Label-sc-15v1nk5-0 QuickSearch___StyledLabel4-sc-rtz2vl-9 gJxZPQ gpRcpM']"));
		for(WebElement price : prices) {
			System.out.println(price.getText());
		}

		driver.findElement(By.xpath("(//span[@class='Label-sc-15v1nk5-0 QuickSearch___StyledLabel2-sc-rtz2vl-7 gJxZPQ gFDEBU'])[18]")).click();
				
		Thread.sleep(3000);
		driver.quit();
	}

}

