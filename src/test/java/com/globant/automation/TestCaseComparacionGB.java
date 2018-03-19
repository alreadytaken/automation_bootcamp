package com.globant.automation;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseComparacionGB  {

	public TestCaseComparacionGB() {
		
		
	}

	//GooglePage objetoG = new GooglePage();
	//BingPage objetoB = new BingPage();
	
	WebDriver driver;
	private static final Logger LOG;
	
	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}
	
	@DataProvider(name= "DataSearch")
	public Object[][] DataSearch(){
		
		return new Object[][] {
			{"celulares"}, {"computadoras"}
		};
	}
	
	/**funcion que llena el array de tipo string con los datos obtenidos de la busqueda*/
	public void LlenarArrayString(List <String> arr, List <WebElement> ListaElementos) {
		for (int i=0; i<5; i++){
			arr.add(ListaElementos.get(i).getText());
		}
	}
	
	
	/**TEST**/
	
	@Test(dataProvider="DataSearch")
	public void searchTest(String search) throws InterruptedException {
		LOG.info("----Search test-----");
		
		
		

		
		/**listas de strings con los resultados*/
		List <String> resultadosGoogle = new ArrayList<>();
		List <String> resultadosBing = new ArrayList<>();			
		
		driver = BrowserFactory.startBrowser("chrome", "http://google.com"); //Inicio el navegador y voy a la url
		GooglePage google_page = new GooglePage(driver);
		google_page.sendDataGoogle(search); //manda los inputs a buscar
		google_page.listaResultados(); //busco los webelements 
		LlenarArrayString(resultadosGoogle, google_page.resG); //lleno la lista de strings con los primeros 5
		
		
		BrowserFactory.startBrowser("chrome", "http://bing.com"); //Inicio el navegador y voy a la url
		BingPage bing_page = new BingPage(driver);
		bing_page.SendDataBing(search); //manda los inputs a buscar
		bing_page.listaResultados(); //busco los webelements 
		LlenarArrayString(resultadosBing, bing_page.resB); //lleno la lista de strings con los primeros 5
			
		
		/** Comparo*/
		
		for (int i=0; i < 5; i++) {			
			Assert.assertEquals(resultadosGoogle.get(i), resultadosBing.get(i));
		}
				
	} /**FIN TEST**/
	
	
	
	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("----Prepare test----");		
	}


	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass
	private void prepareClass() {
		LOG.info("-----Prepare class-----");
		
		
		WebDriverManager.chromedriver().setup();
		
	}	
	
		
	
}//class
