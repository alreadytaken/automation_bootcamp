package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CorreoMain {
private WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "//div[@class='qHbUsHxyUQWPPgj-Wwl5s']/span")
	List <WebElement> mailSubjectList;
	@FindBy (how = How.XPATH, using = "//div[@id='app']//div[contains(text(),'New message')]")
	WebElement newMailButton;
	
	public CorreoMain(WebDriver driver){
		this.driver =driver;
		SeleniumUtils.WaitUntilVisibility(By.xpath("//div[@class='mYbuYnVOeA_vHVJJZPEzu']"), driver);
		SeleniumUtils.WaitUntilVisibility(By.xpath("//div[@id='app']//div[contains(text(),'New message')]"), driver);
		//SeleniumUtils.WaitUntilClickable(By.id("idSIButton9"), driver);
		PageFactory.initElements(driver, this);
	}
	public List <String> displayAllSubjects(){
		List <String> Subjects;
		Subjects = new ArrayList<>(); 
		for (int i=0;i<mailSubjectList.size();i++) {
		Subjects.add(mailSubjectList.get(i).getText());
		}
		return Subjects;
	}	
	public void clickNewMail() {
		newMailButton.click();
	}
}
