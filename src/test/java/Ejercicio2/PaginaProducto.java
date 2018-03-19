package Ejercicio2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaginaProducto extends PageObject {
	@FindBy(how = How.XPATH, using = "/html/body/main/div/div[1]/div[2]/div[1]/section[1]/div/header/h1")
	private WebElement NombreProducto;
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div/div[1]/div[2]/div[1]/section[1]/div/form/fieldset[1]/span[2]/span[2]")
	private WebElement PrecioProducto;
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div/div[1]/div[2]/div[1]/section[1]/div/form/fieldset[1]/div/p")
	private WebElement DescuentoProducto;
	
	public PaginaProducto(WebDriver driver) {
        super(driver);
	}
	
	public WebElement getnombreproducto() {
		return NombreProducto;
	}
	
	public WebElement getprecioproducto() {
		return PrecioProducto;
	}
	
	public WebElement getdescuentoproducto() {
		return DescuentoProducto;
	}

}
