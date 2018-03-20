package com.globant.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MercadoLibreMain {
	private WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "//div/section[@class='recommendations']//span[@class='price-tag ui-item__price']/span[@class='price-tag-fraction']")
	WebElement firstItemPrice;
	@FindBy (how = How.XPATH, using = "//div/section[@class='recommendations']//span[@class='ui-item__discount-text']")
	WebElement firstItemDto;
	@FindBy (how = How.XPATH, using = "//div/section[@class='recommendations']//p[@class='ui-item__title'][@itemprop=\"name\"]")
	WebElement firstItemTxt;
	
	public MercadoLibreMain(WebDriver driver) {
		this.driver=driver;
		SeleniumUtils.WaitUntilPresence(By.xpath("//div/section[@class='recommendations']//p[@class='ui-item__title'][@itemprop=\"name\"]"), driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getPriceInfo() {	
	String price = firstItemPrice.getText();
	System.out.println(price);
	return (price);
	}
	
	public String getDtoInfo() {
	String dto = firstItemDto.getText();
	System.out.println(dto);
	return(dto);
	}
	public String getTxtInfo() {
	Actions action = new Actions(driver);
	action.moveToElement (firstItemPrice).build().perform();
	String Teextoo = firstItemTxt.getText();
	System.out.println(Teextoo);
	return(Teextoo);
	}
	public ItemPage goToItem() {
		firstItemPrice.click();
		return new ItemPage(driver);
	}
	
}
