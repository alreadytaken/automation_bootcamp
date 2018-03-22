package test.pedidos.ya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.globant.automation.SeleniumUtils;

public class DescripcionDeSugerencia {
	
	@FindBy(how = How.XPATH, using ="//div[@id='footerOpen']/a[@class= 'button']")
	private WebElement addToOrderButton;
	
	@FindBy(how = How.XPATH, using ="//div[@class='price total-price']")
	private WebElement totalPrice;
	
	@FindBy(how = How.XPATH, using = "//section[@id = 'deliveryType']//span")
	private WebElement address;
	
	@FindBy(how = How.XPATH, using = "//a[@id='order']")
	private WebElement continueButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='tbox']")
	private WebElement loginPopUp;

	private WebDriver driver;
	
	public DescripcionDeSugerencia(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(addToOrderButton, driver);
	}

	public String getTotalPrice() {

		SeleniumUtils.waitUntilClickable(continueButton, driver);
		return totalPrice.getAttribute("innerText");
	}
	
	public String getAddress() {

		SeleniumUtils.waitUntilClickable(continueButton, driver);
		return address.getAttribute("title");
	}
	
	public void agregarPedido() {

		addToOrderButton.click();
	}
	
	public void confirmarCompra() {
		
		continueButton.click();
	}
	
	public boolean loginVisible() throws InterruptedException {

		SeleniumUtils.waitUntilClickable(loginPopUp, driver);
		return loginPopUp.isDisplayed();
	}
}
