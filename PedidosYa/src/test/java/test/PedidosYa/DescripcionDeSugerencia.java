package test.PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.globant.automation.SeleniumUtils;

public class DescripcionDeSugerencia {
	
	@FindBy(how = How.XPATH, using ="//a[@class = 'button']")
	private WebElement addToOrderButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='price total-price']")
	private WebElement totalPrice;
	
	@FindBy(how = How.ID, using = "deliveryType")
	private WebElement address;
	
	@FindBy(how = How.ID, using = "order")
	private WebElement continueButton;
	
	@FindBy(how = How.ID, using = "modalLogin")
	private WebElement modalLogin;
	
	@FindBy(how = How.XPATH, using = "//div[@class='tcontent']/iframe")
	private WebElement loginPopUp;


	private WebDriver driver;
	
	public DescripcionDeSugerencia(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(addToOrderButton, driver);
	}

	public String getTotalPrice() {

		SeleniumUtils.waitUntilClickable(continueButton, driver);
		return totalPrice.getText();
	}
	
	public String getAddress() {

		SeleniumUtils.waitUntilClickable(continueButton, driver);
		return address.findElement(By.xpath("//section[@id = 'deliveryType']//span")).getAttribute("title");
	}
	
	public void agregarPedido() {

		addToOrderButton.click();
	}
	
	public LoginPedidosYa confirmarCompra() {
		
		continueButton.click();
		SeleniumUtils.waitUntilClickable(modalLogin, driver);
		WebElement iframe = driver.findElement(By.xpath("//div[@class='tcontent']/iframe"));
		SeleniumUtils.waitUntilClickable(iframe, driver);
		driver.switchTo().frame(iframe);
		return new LoginPedidosYa(driver);
	}
}

