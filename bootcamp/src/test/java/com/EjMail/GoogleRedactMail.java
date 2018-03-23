package com.EjMail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PedidosYa.SeleniumUtils;

public class GoogleRedactMail {

	
	protected WebDriver driver;
	public GoogleRedactMail(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
        SeleniumUtils.waitUntilClickable(To, driver);
        
		
		
		
	}
	
	
	
	
	
	@FindBy(xpath="//div[contains(@class,'wO nr l1')]/textarea")
	WebElement To;
	
	@FindBy(name="subjectbox")
	WebElement Subject;
	
	@FindBy(xpath="//div[contains(@id,':bq')]")
	WebElement Body;
	
	@FindBy(xpath="//div[contains(@id,'93')]")
	WebElement btnSend;
	
	public void putTo(String text) {
		SeleniumUtils.waitUntilClickable(To, driver);
		To.click();
		To.sendKeys(text);
	}
	
	public void putSubject(String text) {
		SeleniumUtils.waitUntilClickable(Subject, driver);
		Subject.click();
		Subject.sendKeys(text);
		//Subject.sendKeys(Keys.TAB);
	}
	
	public void putBody(String text) {
		SeleniumUtils.waitUntilClickable(Body, driver);
		Body.click();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].textContent= arguments[1];", Body,"SomeTsdext");

	}
	
	public void clickSend() {
		btnSend.click();
	}
	
	
	
	
	
	
	
	
}
