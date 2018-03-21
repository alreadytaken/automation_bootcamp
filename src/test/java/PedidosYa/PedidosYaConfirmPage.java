package PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaConfirmPage {

	private WebDriver driver;
		
	public PedidosYaConfirmPage(WebDriver driver){
		this.driver = driver;
		//a[@class='button']
		if (!SeleniumUtils.isPresent(By.xpath("//div[@class='content_img_most_ordered']"), driver)) {
			throw new IllegalStateException("Page did not load");
		}
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='button']")
	private WebElement button;
	
	@FindBy(xpath="//div[@class='data']/span")
	private WebElement address;
	
	@FindBy(xpath="//span[@id='scrollContent']//section[@id=' ']/div[@data-auto]")
	private WebElement totalPrice;
	
	@FindBy(id="order")
	private WebElement order;
	
	public boolean validate(String data, String data2) {
		return ((address.getText()==data) && (totalPrice.getText()==data2));
	}
	
	public void confirmPromo() {
		this.button.click();
	}
	
	public PedidosYaConfirmPage orderFood() {
		this.order.click();
		return new PedidosYaConfirmPage(driver);
	}
		
}