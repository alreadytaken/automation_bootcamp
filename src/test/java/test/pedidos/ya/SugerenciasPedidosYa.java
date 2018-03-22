package test.pedidos.ya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.globant.automation.SeleniumUtils;

public class SugerenciasPedidosYa {
	
	@FindBy(how = How.XPATH, using = "//div[@class='content_featured_prod  fp_abTest']//a[@data-sliderid='1']")
	private WebElement suggestion; 
	
	@FindBy(how = How.XPATH, using ="//div[@class='content_featured_prod  fp_abTest']//a[@data-sliderid='1']//span[@class= 'after_price']")
	private WebElement price;
	
	private WebDriver driver;
	
	public SugerenciasPedidosYa(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(suggestion, driver);
	}
	
	public String getPrice() {

		return price.getAttribute("textContent");
	}
	
	public DescripcionDeSugerencia seleccionarSugerencia() {
		
		this.suggestion.click();
		return new DescripcionDeSugerencia(driver);
	}
}
