package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaCountrySel {
	
	private WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "//div/section/ul[@class='flags']//div[@class='flag-sprite uruguay']")
	WebElement countryButtonUruguay;
	
	@FindBy (how = How.XPATH, using = "//div/section/ul[@class='flags']//li[@class='flag']")
	List <WebElement> countryButtons;
	
	
	
	public PedidosYaCountrySel (WebDriver driver){
		this.driver =driver;
		SeleniumUtils.WaitUntilPresenceList(By.xpath("//div/section/ul[@class='flags']//div[@class='flag-sprite uruguay']"), driver);
		PageFactory.initElements(driver, this);
	}
	
	public List <Object> getAllCounties(){
		List <Object> banderas;
		banderas = new ArrayList<>();    
		for (int i=0;i<countryButtons.size();i++) {
			String nombredelpais = countryButtons.get(i).getText();
			banderas.add(nombredelpais);
		}
		return banderas;
	}
	
	public PedidosYaUruguayMain clickOnUruguay() {
		countryButtonUruguay.click();
		return new PedidosYaUruguayMain(driver);
	}
}
