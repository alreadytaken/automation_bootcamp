package com.globant.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {

	
	@FindBy (how = How.XPATH, using = "//div/section[@id='short-desc']//span[@class='price-tag']/span[@class='price-tag-fraction']")
	WebElement inItemPrice;
	@FindBy (how = How.XPATH, using = "//div/section[@id='short-desc']//div[@class='price-tag discount-arrow arrow-left']/p")
	WebElement inItemDto;
	@FindBy (how = How.XPATH, using = "//div/section[@id='short-desc']//h1[@class='item-title__primary ']")
	WebElement inItemTxt;
	
	public ItemPage (WebDriver driver){
		SeleniumUtils.WaitUntilVisibility(By.xpath("//div/section[@id='short-desc']//div[@class='vip-actions-wrapper  ']"), driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getInItemPriceInfo() {
		String InItemPrice=inItemPrice.getText();
		System.out.println(InItemPrice);
		return (InItemPrice);
	}
	public String getInItemDtoInfo() {
		String InItemDto=inItemDto.getText();
		System.out.println(InItemDto);
		return (InItemDto);
	}
	public String getInItemTxtInfo() {
		String InItemTxt=inItemTxt.getText();
		System.out.println(InItemTxt);
		return (InItemTxt);
	}
}
