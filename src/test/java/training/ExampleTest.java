package com.globant.automation;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EjemploTest {
	
	
	
	private WebDriver driver;
	
	
	private static final Logger LOG=LogManager.getLogger(EjemploTest.class);
	
    @Test
	public void prueba() {
	LOG.info("test");
	driver.get("http://www.newtours.demoaut.com");
	
	//creo los objetos webelement referenciando a los campos en la pagina web
	WebElement potatoUser = driver.findElement(By.name("userName"));
	WebElement potatoPass = driver.findElement(By.name("password"));
	WebElement potatoLogin = driver.findElement(By.name("login"));
	driver.findElement(By.name("userName"));
	driver.findElement(By.name("password"));
	driver.findElement(By.name("login"));
	
	//ingreso los datos a colocar en los respectivos campos
	potatoUser.sendKeys("hola, esto anda");
	potatoPass.sendKeys("xd");
	potatoLogin.click();
	
	
	driver.close();
    }
    @BeforeMethod
    public void pruebabt() {
	LOG.info("Abre navegador");
	driver=new ChromeDriver();
		
		}		
    @AfterMethod
	public void pruebaat() {
	LOG.info("Cerrando navegador");	
	driver.quit();
	}
    @BeforeClass
    public void pruebabc() {
	LOG.info("Instalando el driver de chrome");
	WebDriverManager.chromedriver().setup();
	
			
}
    @AfterClass
    public void pruebaac() {
	LOG.info("Metodo After class");		
}
    /*@Test
    public void pruebast() {
	LOG.info("Segundo test");
    }
    @DataProvider(name="Authentication")
    public Object[][] provider(){
    	return new Object [][] {{ "testuser_1", "Test@123","Juan" },{ "testuser_1", "Test@123","Pedro"}};
    	    	
    }
    @Test (dataProvider="Authentication")
    public void test(String sUsername, String sPassword,String sNombre) {
    	LOG.info(sUsername);
    	LOG.info(sPassword);
        LOG.info(sNombre);
    	Assert.assertEquals(sPassword, sPassword,"Usuario y contraseña");
    	Assert.assertEquals(sUsername, sUsername,"Usuario repetido");
    	
    }
    
    */
    
}
