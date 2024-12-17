package Practise;

import java.util.Iterator;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToReadTheColorsFromAmazon {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphones");
		driver.findElement(By.id("nav-search-submit-button")).click();		
		List<WebElement> colors = driver.findElements(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Starlight']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']//a"));
		for(WebElement color : colors) {
			@Nullable
			String value = color.getAttribute("aria-label");
			System.out.println(value);
		}
		
	}

}
