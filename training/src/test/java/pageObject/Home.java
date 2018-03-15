package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	
	//Username field and sendkeys
	@FindBy(css="input[name='userName']")
	private WebElement usrField;
	
	public void sendKeysUsrField(String user) {
		usrField.sendKeys(user);
	}
	
	@FindBy(css="input[name='password']")
	private WebElement pwField;
	
	public void sendKeysPwField(String pass) {
		pwField.sendKeys(pass);
	}
	
	@FindBy(css="input[name='login']")
	private WebElement signinButton;
	
	public void clickSigninButton() {
		signinButton.click();
	}
	
}
