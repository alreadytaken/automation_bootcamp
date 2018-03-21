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
		SeleniumUtils.waitUntilPresence(By.xpath("//div/iframe"), driver);
		driver.switchTo().frame(iframe);

	
		
	}
	
	@FindBy(xpath="//div/iframe")
        WebElement iframe;

	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="login")
        WebElement logInButton;
	
	
	
	public void logIn(String text){
		
		email.click();
		email.sendKeys(text);
   
	}
public void logIn2(String text){
		
		password.click();
		password.sendKeys(text);
		password.sendKeys(Keys.ENTER);
   
	}
	public void clickLogButton() {
	logInButton.click();
}
	
	
	
}
