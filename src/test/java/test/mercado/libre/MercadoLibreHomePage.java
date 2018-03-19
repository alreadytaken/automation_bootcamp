package test.mercado.libre;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class MercadoLibreHomePage {
	
	//Filtro Precios de Slides Activos
	@FindBy(how = How.XPATH, using = "//h1[text()='Ofertas de la semana']/../..//div[@class='slick-track']//div[@class='ui-item__price-block']//span[@class='price-tag ui-item__price']/span[@class='price-tag-fraction']")
	private List<WebElement> preciosDeOfertasSemanales;

	//Filtro descuentos de Slides Activos
	@FindBy(how = How.XPATH, using = "//h1[text()='Ofertas de la semana']/../..//div[@class='slick-track']//div[@class='ui-item__price-block']//span[@class='ui-item__discount-text']")
	private List<WebElement> descuentosDeOfertasSemanales;
	
	//Filtro nombres de slides Activos
	@FindBy(how = How.XPATH, using = "//h1[text()='Ofertas de la semana']/../..//div[@class='slick-track']//div[@class='ui-item__content']//p[@class='ui-item__title']")
	private List<WebElement> nombreProductosEnOfertasSemanales;
/*			
	@FindBy(how = How.XPATH, using ="//h1[text()='Ofertas de la semana']/../..//div[@class='slick-track']/div/div/a/@href")
	private List<WebElement> urlOfertasSemanales;
*/
	private WebDriver driver;

	public MercadoLibreHomePage(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);

	}
	
	public String getPreciosSemanales(int i) {
		return preciosDeOfertasSemanales.get(i).getAttribute("textContent");
	}
	
	public String getDescuentosSemanales(int i) {
		return descuentosDeOfertasSemanales.get(i).getAttribute("textContent");
	}
	
	public String getNombreProducto(int i) {
		return nombreProductosEnOfertasSemanales.get(i).getAttribute("textContent");
	}
	
	public int getTamanho() {
		return preciosDeOfertasSemanales.size();
	}
	
	/*
	public String getUrlOfertaSemanal(int i) {
		return nombreProductosEnOfertasSemanales.get(i).getAttribute("href");
	}
	*/
	
	public MercadoLibreProductoEnOfertaSemanal seleccionarProducto(int i) {
		//String tab = Keys.chord(Keys.CONTROL + Keys.RETURN + "2");
		preciosDeOfertasSemanales.get(i).click();
		return new MercadoLibreProductoEnOfertaSemanal(driver);
	}
	
}
	/*
	public boolean comprobarProductos(MercadoLibreProductoEnOfertaSemanal m, int i) {
		String beforePrice = preciosDeOfertasSemanales.get(i).getAttribute("textContent");
		String beforeDiscount = descuentosDeOfertasSemanales.get(i).getAttribute("textContent");
		String beforeName = nombreProductosEnOfertasSemanales.get(i).getAttribute("textContent");
		
		String afterName =  m.getNombreProducto();
		String afterDiscount =m.getDescuentoProducto();
		String afterPrice =m.getPrecioProducto();
		
		if((afterName.equals(beforeName)==true)&&(afterPrice.equals(beforePrice)==true)&&(afterDiscount.equals(beforeDiscount)==true)) {
			return true;
		}
		else {
			return false;
		}
	}
	public List<String> pricesInSlideActive(){
		List<String> res = new ArrayList();
		int tam = preciosDeOfertasSemanales.size();
		for(int j=0; j<tam; j++) {
			res.add(preciosDeOfertasSemanales.get(j).getAttribute("textContent"));
		}
		return res;
	}
	
	public List<String> namesInSlideActive(){
		List<String> res = new ArrayList();
		int tam = nombreProductosEnOfertasSemanales.size();
		for(int j=0; j<tam; j++) {
			res.add(nombreProductosEnOfertasSemanales.get(j).getAttribute("textContent"));
		}
		return res;
	}
	
	public List<String> discountsInSlideActive(){
		List<String> res = new ArrayList();
		int tam = descuentosDeOfertasSemanales.size();
		for(int j=0; j<tam; j++) {
			res.add(descuentosDeOfertasSemanales.get(j).getAttribute("textContent"));
		}
		return res;
	}
*/
	

