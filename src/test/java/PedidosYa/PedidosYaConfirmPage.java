package PedidosYa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
private static final Logger LOG;
    
    static {
        LOG = LogManager.getLogger(PedidosYaTestPage.class);
    }

	@FindBy(xpath="//*[@id='footerOpen']/a[contains(text(), 'Agregar a mi pedido (')]")
	private WebElement button;
	
	
	
	public String dirConf(){
		String data = driver.findElement(By.xpath("//div[@class='data']/span")).getAttribute("title");
		return data;
	}
	
	@FindBy(xpath="//span[@id='scrollContent']//section[@id=' ']/div[@data-auto]")
	private WebElement totalPrice;
	
	@FindBy(id="order")
	private WebElement order;
	
	public boolean validate(String data, String data2) {
		
		SeleniumUtils.waitUntilClickables(By.id("order"), driver);
		String direccion = dirConf();
		boolean trueDire = direccion.equals(data);
		boolean truePrice = totalPrice.getText().equals(data2);
		return (trueDire && truePrice);
	}
	
	public void confirmPromo() {
		SeleniumUtils.waitUntilClickable(button, driver);
		this.button.click();
	}
	
	public PedidosYaPopUpPage orderFood() {
		SeleniumUtils.waitUntilClickable(order, driver);
		this.order.click();
		return new PedidosYaPopUpPage(driver);
	}
		
}