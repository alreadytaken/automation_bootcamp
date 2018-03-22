package test.mercado.libre;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MercadoLibreProductoEnOfertaSemanal {

	@FindBy(how = How.XPATH, using = "//h1[@class='item-title__primary ']")
	private WebElement nombreProducto;
	
	@FindBy(how = How.XPATH, using = "//span[@class='price-tag']/span[@class='price-tag-fraction']")
	private WebElement precioProducto;
	
	@FindBy(how = How.XPATH, using = "//div[@class='price-tag discount-arrow arrow-left']")
	private WebElement descuentoProducto;
	
	@FindBy(how = How.XPATH, using = "//input[@id ='nav-header-menu-switch']//../a[@class = 'nav-logo']")
	private WebElement home;
	
	private WebDriver driver;
	
	public MercadoLibreProductoEnOfertaSemanal(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getNombreProducto() {

		return nombreProducto.getAttribute("innerText");
	}
	
	public String getPrecioProducto() {

		return precioProducto.getAttribute("innerText");
	}
	
	public String getDescuentoProducto() {

		return descuentoProducto.getAttribute("innerText");
	}
	
	public MercadoLibreHomePage goHome() {
		this.home.click();
		return new MercadoLibreHomePage(driver);
	}
}
