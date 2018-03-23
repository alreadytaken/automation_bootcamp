package mail;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewMessage {
	
	@FindBy(how = How.ID, using = ":b5")
	private WebElement destinationBox;
	
	@FindBy(how = How.ID, using = ":av")
	private WebElement subjectBox;
	
	@FindBy(how = How.ID, using = ":bz")
	private WebElement bodyBox;
	
	@FindBy(how = How.ID, using = ":ak")
	private WebElement sendButton;
	
	private WebDriver driver;
	
	public NewMessage(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);

	}
	
	public void sendMailTo(String to) {
		
		destinationBox.sendKeys(to);
	}
	
	public void completeSubject(String subject) {
	
		subjectBox.sendKeys(subject);
	}
	
	public void writeBody(String body) {
		
		bodyBox.sendKeys(body);
	}
	
	public void sendEmail() {
		sendButton.click();
	}

}
