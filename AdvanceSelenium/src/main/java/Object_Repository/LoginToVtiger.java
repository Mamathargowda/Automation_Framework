package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToVtiger {
	public LoginToVtiger(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name") private WebElement UserTextField;
    @FindBy(name="user_password") private WebElement PassWordTextField;
    @FindBy(id="submitButton") private WebElement LoginButton;
    
	public WebElement getUserTextField() {
		return UserTextField;
	}
	public WebElement getPassWordTextField() {
		return PassWordTextField;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}
    
	public void loginIntoVtiger(String username, String password) {
		UserTextField.sendKeys(username);
		PassWordTextField.sendKeys(password);
		LoginButton.click();
	}
    
}
