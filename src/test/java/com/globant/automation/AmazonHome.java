package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.util.SeleniumUtils;

public class AmazonHome {

		private WebDriver driver;

		public AmazonHome(WebDriver driver){
			this.driver = driver;
			
			if (!SeleniumUtils.isPresent(By.id("twotabsearchtextbox"), driver)) {
				throw new IllegalStateException("Page did not load");
			}		
			PageFactory.initElements(driver, this);
		}
		
	
		@FindBy(xpath="//input[@type='submit'")
		private WebElement button;
		
		@FindBy(id="twotabsearchtextbox")
		private WebElement search;
		
		public void typeSearch(String data) {
			this.search.sendKeys(data);
		}
	
		public AmazonSelected click() {
			this.button.click();
			return new AmazonSelected(driver);
		}
	}
	
