package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.automation.util.SeleniumUtils;

public class LinkedInMessege extends BasePage{

	public LinkedInMessege(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath =("//a[@class='msg-conversations-container__compose-link button-tertiary-medium-round ember-view']"))
	private WebElement newMessage;
	
	@FindBy (xpath = ("//div[@class='msg-connections-typeahead__added-recipients']/input"))
	private WebElement writeUser;

	@FindBy (xpath = ("//dt[@class=\'t-14 t-black t-bold truncate\']"))
	private WebElement clickOnUser;

	@FindBy (xpath = ("//button[@class='msg-form__send-button button-primary-small']"))
	private WebElement sendMessege;

	@FindBy (xpath = ("//div[@class='nav-item__content']"))
	private WebElement me;
	
	@FindBy (xpath = ("(//a[@class='block ember-view'])[4]"))
	private WebElement signOut;
	
	public LinkedInMessege newMes(){
		if (SeleniumUtils.waitForElementToBeVisible(newMessage, driver)) {
			newMessage.click();
		}
		return new LinkedInMessege(driver);
	}

	public LinkedInMessege EmailOrUser(String str){
		if (SeleniumUtils.waitForElementToBeVisible(writeUser, driver)) {
			writeUser.sendKeys(str);
		}
		return new LinkedInMessege(driver);
	}
	
	public LinkedInMessege writeMessege(String str) {
		WebElement newMessage = SeleniumUtils.getWebElement(driver, By.xpath("//div[@class='msg-form__contenteditable t-14 t-black--light t-normal flex-grow-1']"));
		if (SeleniumUtils.waitForElementToBeVisible(newMessage, driver)) {
			newMessage.sendKeys();

		Random numb = new Random();
		for(int i = 0; i<10; i++) {
			newMessage.sendKeys(str + numb.nextInt());
			break;
		}
		}
		return new LinkedInMessege(driver);
	}
	
	public LinkedInMessege ClickUser(){
		if (SeleniumUtils.waitForElementToBeVisible(clickOnUser, driver)) {
			clickOnUser.click();
		}
		return new LinkedInMessege(driver);
	}

	public LinkedInMessege sendMessegeButton() {
		if (SeleniumUtils.waitForElementToBeVisible(sendMessege, driver)) {
			sendMessege.click();
			
		}
		return new LinkedInMessege(driver);

	}
	
	public LinkedInMessege clickMe() {
		if (SeleniumUtils.waitForElementToBeVisible(me, driver)) {
			me.click();
		}
		return new LinkedInMessege(driver);
		
	}
	public LinkedInMessege clickSignOut() {
		if (SeleniumUtils.waitForElementToBeVisible(signOut, driver)) {
			signOut.click();
		}
		return new LinkedInMessege(driver);
		
	}
	
}


