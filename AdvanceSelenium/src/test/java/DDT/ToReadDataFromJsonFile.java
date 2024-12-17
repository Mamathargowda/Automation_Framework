package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ToReadDataFromJsonFile {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Harsha\\Desktop\\jsondata.json");
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(fis);
		String BROWSER = data.get("browser").asText();
		String 	URL = data.get("url").asText();
		String USERNAME = data.get("username").asText();
		String PASSWORD = data.get("password").asText();
		
		WebDriver driver;
		
		
	}

}
