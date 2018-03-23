package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class newMailPage {
	private WebDriver driver;
	@FindBy(how = How.XPATH, using = "//div[@id='app']//*//input[@type='text']")
	WebElement mailToBox;
	@FindBy(how = How.XPATH, using = "//div[@id='app']//*//input[@id='subjectLine0']")
	WebElement mailSubjectBox;
	@FindBy(how = How.XPATH, using = "//div[@id='app']//*//div[@dir='ltr']")
	WebElement mailBodyBox;
	@FindBy(how = How.XPATH, using = "//div[@id='app']//*[contains(text(),'Send')]")
	WebElement mailSendButton;

	public newMailPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.WaitUntilPresence(By.xpath("//div[@id='app']//*//input[@type='text']"), driver);
		SeleniumUtils.WaitUntilPresence(By.xpath("//div[@id='app']//*//input[@id='subjectLine0']"), driver);
		// SeleniumUtils.WaitUntilVisibility(By.xpath("//div[@id='app']//*[contains(text(),'New
		// message')]"), driver);
		// SeleniumUtils.WaitUntilClickable(By.id("idSIButton9"), driver);
		PageFactory.initElements(driver, this);
	}

	public void insertReciever(String reciever) {
		mailToBox.sendKeys(reciever);
		mailToBox.sendKeys(Keys.ENTER);
	}

	public void insertSubject(String subject) {
		mailSubjectBox.sendKeys(subject);
	}

	public void insertBody(String body) {
		mailBodyBox.sendKeys(body);
	}

	public void mailSend() {
		mailSendButton.click();
	}
}
