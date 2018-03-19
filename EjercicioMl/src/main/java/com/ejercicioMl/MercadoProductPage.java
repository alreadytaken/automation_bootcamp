package com.ejercicioMl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class MercadoProductPage extends MercadoHomePage   {
	WebDriver driver;
	public MercadoProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		

		
	}
	
	
	public static Logger LOG=LogManager.getLogger(MercadoProductPage.class);
	
	


	@FindBy(xpath="//*[contains(@class,'price-tag')]/*[contains(@class,'price-tag-fraction')]")
	WebElement precioProducto2;
	

	@FindBy(xpath="//*[contains(@class,'price-tag discount-arrow arrow-left')]")
	WebElement descuentoProducto2;
	
	@FindBy(xpath="//*[contains(@class,'item-title__primary')]")
	WebElement tituloProducto2;
	
	@FindBy(xpath="//h1[text()='Ofertas de la semana']/following::div[contains(@class,'ui-item__image-container')]")
	WebElement container;
	

	 
	
	public void leerDatos() throws InterruptedException {


		
		 for (int i=0;i<10;i++)
		    {
		        
			 Actions builder = new Actions(driver);
			 if(i>=5 ) {
				    
				    builder.moveToElement(container).perform();
				    
					botonPasar.click();
					
				}
				SeleniumUtils.waitUntilClickable(precios.get(i), driver);

			 builder.moveToElement(precios.get(i)).perform();
		
		
		
		List <String> ar = new ArrayList<>();
		

    
		String p = precios.get(i).getText();
		String d = descuentoProducto.get(i).getText();
		String t = tituloProducto.get(i).getText();
		ar.add(p);
		ar.add(d);
		ar.add(t);
		LOG.info(ar);
		
        precios.get(i).click();
        
		
		
       List <String> ar2 = new ArrayList<>();
		String p2 = precioProducto2.getText();
		String d2 = descuentoProducto2.getText();
		String t2 = tituloProducto2.getText();
		ar2.add(p2);
		ar2.add(d2);
		ar2.add(t2);
		
		
		
		
		LOG.info(ar2);
		Assert.assertEquals(ar, ar2);
		
		driver.navigate().back();
		    }
	}
		
		
	

	
	
	
	
	
	
	
}
