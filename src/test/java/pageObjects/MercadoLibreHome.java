package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class MercadoLibreHome {

	protected WebDriver driver;
	
	public MercadoLibreHome(WebDriver driver){
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.cssSelector(".recommendations button[class='next-button icon-right-open-big ']"), driver);
		SeleniumUtils.waitUntilVisible(By.cssSelector("span[class='price-tag ui-item__price'] .price-tag-fraction"), driver);
		SeleniumUtils.waitUntilVisible(By.cssSelector(".recommendations .ui-item__discount-text"), driver);
		PageFactory.initElements(driver, this);
		}
	
	public MercadoLibreHome(WebDriver driver,int i){ //Overload de constructor para utilizar en los page objects de scrolleo
		this.driver = driver;
		//SeleniumUtils.waitUntilPresent(By.cssSelector(".recommendations button[class='next-button icon-right-open-big ']"), driver);
		
		Actions action = new Actions(driver);
		
		WebElement we = driver.findElement(By.cssSelector(".recommendations>div"));
		action.moveToElement(we).moveToElement(driver.findElement(By.cssSelector(".recommendations button[class='next-button icon-right-open-big ']"))).click().build().perform();
		PageFactory.initElements(driver, this);
		}
	
	public MercadoLibreHome(WebDriver driver,int i, int e){
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.cssSelector(".recommendations button[class='next-button icon-right-open-big ']"), driver);
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.cssSelector(".recommendations>div"));
		action.moveToElement(we).moveToElement(driver.findElement(By.cssSelector(".recommendations button[class='next-button icon-right-open-big ']"))).click().build().perform();
		PageFactory.initElements(driver, this);
		}
	
	public MercadoLibreHome(WebDriver driver,int i, int e, int f){
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.cssSelector(".recommendations button[class='next-button icon-right-open-big ']"), driver);
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.cssSelector(".recommendations>div"));
		action.moveToElement(we).moveToElement(driver.findElement(By.cssSelector(".recommendations button[class='next-button icon-right-open-big ']"))).click().build().perform();
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(how = How.CSS, using = ".recommendations img") //Guardo las imagenes de las ofertas, porque en el 'alt' contienen el nombre
	private List<WebElement> dealsTitle;
	
	@FindBy(how = How.CSS, using = "span[class='price-tag ui-item__price'] .price-tag-fraction")
	private List<WebElement> dealsPrice;
	
	@FindBy(how = How.CSS, using = ".recommendations .ui-item__discount-text")
	private List<WebElement> dealsDiscount;
	
	@FindBy(how = How.CSS, using = "span[class='price-tag ui-item__price'] .price-tag-symbol")
	private List<WebElement> dealsCurrency;
	
	@FindBy(how = How.CSS, using = ".recommendations .carousel-container a")
	private List<WebElement> dealsLink;
	
	
	private List<String> titleText = new ArrayList<>();
	private List<String> currencyText = new ArrayList<>();
	private List<String> priceText = new ArrayList<>();
	private List<String> discountText = new ArrayList<>();
	public List<String> linkText = new ArrayList<>(); //Es publica para poder acceder al link desde el caso de prueba
	
	public void saveDeals() {

		for(WebElement deal: dealsTitle) {
			titleText.add(deal.getAttribute("alt").trim());
		}
		for(WebElement deal: dealsPrice) {
			priceText.add(deal.getText());
		}
		for(WebElement deal: dealsDiscount) {
			discountText.add(deal.getText());
		}
		
		for(WebElement deal: dealsLink) {
			linkText.add(deal.getAttribute("href"));
		}
		for(WebElement deal : dealsCurrency) {
			currencyText.add(deal.getText());
		}
	}
	
	public List<String> getDeal(int index) {
		//Este metodo genera una lista con Titulo, Precio y Descuento 
		//de un item de las ofertas seleccionado mediante el numero index
		List<String> aux = new ArrayList<>();
		
		aux.add(titleText.get(index));
		aux.add(currencyText.get(index));
		aux.add(priceText.get(index));
		aux.add(discountText.get(index));
			
		return aux;
		
	}
	

}
