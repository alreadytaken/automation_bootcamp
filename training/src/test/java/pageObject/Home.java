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
	

	
	
	
	
	
	
	
//	@FindBy(id="lst-ib")
//	private WebElement searchBox;
//	
//	public void sendKeysSearchBox(String text) {
//		searchBox.sendKeys(text);
//	}

//	
//	public void clickButton() {
//		button.click();
//	}
}
