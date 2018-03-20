package com.PedidosYa;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpLogin {

	protected WebDriver driver;
	public PopUpLogin(WebDriver driver) {
		
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		SeleniumUtils.waitUntilPresence(By.xpath("//h1"), driver);

	
		
	}
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	
	
	public void logIn(String text){
		
		email.click();
		email.sendKeys(text);
   
	}
public void logIn2(String text){
		
		password.click();
		password.sendKeys(text);
		password.sendKeys(Keys.ENTER);
   
	}
	
}
