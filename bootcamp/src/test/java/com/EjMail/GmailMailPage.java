package com.EjMail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PedidosYa.SeleniumUtils;


public class GmailMailPage {

	protected WebDriver driver;
	public GmailMailPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
        SeleniumUtils.waitUntilClickable(By.xpath("//span[contains(@class,'bog')]/b"), driver);
		
		
		
	}
	
	@FindBy(xpath="//span[contains(@class,'bog')]/b")
	List <WebElement> subjects;
	
	@FindBy(xpath="//div[contains(@class,'T-I J-J5-Ji T-I-KE L3')]")
	WebElement btnRedact;
	
	@FindBy(xpath="//div[contains(@class,'wO nr l1')]")
	WebElement To;
	
	
			
			
	public List<WebElement> getSubjects() {
		
        return subjects;
  }  
	
	
	public void clickRedact() {
		SeleniumUtils.waitUntilClickable(btnRedact, driver);
		btnRedact.click();
		
		
	}
	
	
}
