package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class MercadoLibreOferta {
	
	protected WebDriver driver;
	
	public MercadoLibreOferta(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.className("nav-logo"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = ".item-title__primary")
	WebElement dealTitle;
	
	@FindBy(how = How.CSS, using = "span[class='price-tag']>span:nth-of-type(1)")
	WebElement dealCurrency;
	
	@FindBy(how =How.CSS, using = "span[class='price-tag']>span:nth-of-type(2)")
	WebElement dealPrice;
	
	@FindBy(how = How.CSS, using = "div[class='price-tag discount-arrow arrow-left'] p")
	WebElement dealDiscount;
	
	List <String> dealText = new ArrayList<>();
	
	private void saveDeal() {
		dealText.add(dealTitle.getText());
		dealText.add(dealCurrency.getText());
		dealText.add(dealPrice.getText());
		dealText.add(dealDiscount.getText());
	}
	
	public List<String> getDeal(){
		dealText.clear();
		saveDeal();
		return dealText;
		
	}

}
