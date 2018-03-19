package com.ejercicioMl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MercadoHomePage {
	
	protected WebDriver driver;
	public MercadoHomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	

	
	
	@FindBy(xpath="//h1[text()='Ofertas de la semana']/following::*[contains(@class,'price-tag ui-item__price')]/*[contains(@class,'price-tag-fraction')]")
	public List <WebElement> precios;
	
	@FindBy(xpath="//h1[text()='Ofertas de la semana']/following::*[contains(@class,'ui-item__discount-text')]")
	public List <WebElement> descuentoProducto;
	
	@FindBy(xpath="//h1[text()='Ofertas de la semana']/following::*[contains(@class,'ui-item__title')]")
	public List <WebElement> tituloProducto;
	
	@FindBy(xpath="//h1[text()='Ofertas de la semana']/following::button[contains(@class,'next-button icon-right-open-big ')]")
    public WebElement botonPasar;
	
	
		 
	
	
		
	
}
