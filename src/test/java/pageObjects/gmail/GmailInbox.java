package pageObjects.gmail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GmailInbox {
	protected WebDriver driver;
	
	public GmailInbox(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("span[class='gbqfi gb_hc']"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[role='link'] b")
	List<WebElement> subjectList;
	
	@FindBy(css="div[style='user-select: none;']  div[role='button']")
	WebElement composeButton;
	
	
	public List<String> getSubjects(){
		List<String> aux = new ArrayList<>();
		for(WebElement subject: subjectList) {
			aux.add(subject.getText());
		}
		return aux;
	}
	

}
