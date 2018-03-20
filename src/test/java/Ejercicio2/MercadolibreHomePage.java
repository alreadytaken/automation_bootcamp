package Ejercicio2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.SeleniumUtils;

public class MercadolibreHomePage extends PageObject {
	@FindBy(how = How.XPATH, using  = "/html/body/main/div/div/section[3]/div/div[2]/div/div/div/div[1]/div/a/div[2]/p")
	private WebElement OdlSNombreProducto; //OdlS = Oferta de la Semana^
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div/div/section[3]/div/div[2]/div/div/div/div[1]/div/a/div[2]/div/span[1]/span[2]")
	private WebElement OdlSPrecioProducto; 
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div/div/section[3]/div/div[2]/div/div/div/div[1]/div/a/div[2]/div/span[2]")
	private WebElement OdlSDescuentoProducto; 
	
	@FindBy(how = How.XPATH, using = "(//h1[text()='Ofertas de la semana']/../..//div[@class='ui-item__image-container'])[1]")
	private WebElement FotoProducto;
	
	public MercadolibreHomePage(WebDriver driver) {
        super(driver);
	}
	
	public WebElement getnombreproducto() {
		Actions builder = new Actions(driver);
		builder.moveToElement(FotoProducto).build().perform();
		WebElement OdlSNombreProducto = SeleniumUtils.waitUntilClickable(By.xpath("/html/body/main/div/div/section[3]/div/div[2]/div/div/div/div[1]/div/a/div[2]/p"), driver);
		return OdlSNombreProducto;
	}
	
	public WebElement getprecioproducto() {
		Actions builder = new Actions(driver);
		builder.moveToElement(FotoProducto).perform();
		WebElement OdlSPrecioProducto = SeleniumUtils.waitUntilClickable(By.xpath("/html/body/main/div/div/section[3]/div/div[2]/div/div/div/div[1]/div/a/div[2]/div/span[1]/span[2]"), driver);
		return OdlSPrecioProducto;
	}
	
	public WebElement getdescuentoproducto() {
		Actions builder = new Actions(driver);
		builder.moveToElement(FotoProducto).perform();
		WebElement OdlSDescuentoProducto = SeleniumUtils.waitUntilClickable(By.xpath("/html/body/main/div/div/section[3]/div/div[2]/div/div/div/div[1]/div/a/div[2]/div/span[2]"), driver);
		return OdlSDescuentoProducto;
	}
	
	public PaginaProducto click() {
		FotoProducto.click();
		return new PaginaProducto(driver);
	}

}
