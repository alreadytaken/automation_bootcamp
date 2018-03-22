package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
<<<<<<< HEAD

=======
import junit.framework.Assert;

import java.net.MalformedURLException;
import java.net.URL;
>>>>>>> ac9fe68d19469de7b0751104b21a635b0a4297d2
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
=======
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
>>>>>>> ac9fe68d19469de7b0751104b21a635b0a4297d2
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest {

    public GoogleTest() {

    }

    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(GoogleTest.class);
    }

    @Test
    public void searchTest() throws InterruptedException {
        LOG.info("Search test");
<<<<<<< HEAD

    }

    @Test(dataProvider = "terminosBusqueda")
    public void metodoEjemplo7(String terminoBusqueda) {
    		LOG.info(terminoBusqueda);
    		driver.get("https://google.com");
    		WebElement e=SeleniumUtils.WaitUntilClickable(By.name("q"), driver);
    		e.sendKeys(terminoBusqueda);
    		e.sendKeys(Keys.ENTER);
    		//WebElement resultado=SeleniumUtils.WaitUntilClickable(By.className("r"), driver);
    		//resultado.click();
    		//List <WebElement> resultados;
    		//resultados =new ArrayList<>();
    		List <WebElement> resultadosgoogle;// = driver.findElements(By.xpath ("//div[@class='rc']/h3/a"));
    		resultadosgoogle=(SeleniumUtils.WaitUntilVisibilityList(By.xpath("//div[@class='rc']/h3/a"), driver));
    		LOG.info("Guarde resultados Google");
    		List <String> resultadosgoogletext;
    		resultadosgoogletext = new ArrayList<>();
    		
    		for (int i=0;i<=5;i++) {
    			resultadosgoogletext.add(resultadosgoogle.get(i).getText());
    		}
    		
    		driver.get("https://bing.com");
    		WebElement f=SeleniumUtils.WaitUntilClickable(By.name("q"), driver);
    		f.sendKeys(terminoBusqueda);
    		f.sendKeys(Keys.ENTER);
    		List <WebElement> resultadosbing;// = driver.findElements(By.xpath ("//li[@class='b_algo']/h2/a"));
    		List <String> resultadosbingtext;
    		resultadosbing=(SeleniumUtils.WaitUntilVisibilityList(By.cssSelector("li[class='b_algo'] h2 a"), driver));
    		resultadosbingtext = new ArrayList<>();    		
    		for (int j=0;j<=5;j++) {
    			resultadosbingtext.add(resultadosbing.get(j).getText());
    		//	LOG.info(), arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    		}
    		LOG.info("Guarde resultados bing");
    		for (int k=0;k<5;k++) {
    			Assert.assertEquals(resultadosbingtext.get(k), resultadosgoogletext.get(k), "Verifico si son iguales");
    		}
    		//WebElement txtSearch = driver.findElement(By.id("lst-ib"));
    		//txtSearch.sendKeys(terminoBusqueda);
    		//txtSearch.sendKeys(Keys.ENTER);
    }
    

=======
       // driver.get("http://newtours.demoaut.com/");
    }
    
>>>>>>> ac9fe68d19469de7b0751104b21a635b0a4297d2
    @BeforeMethod
    public void prepareTest() throws MalformedURLException {
    	
    	//DesiredCapabilities caps = DesiredCapabilities.firefox();
        LOG.info("Prepare test");
        //RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps);
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void cleanup() {
       // driver.quit();
    }

    @BeforeClass
    private void prepareClass() {
        LOG.info("Prepare class");
        WebDriverManager.chromedriver().setup();
    }
<<<<<<< HEAD
    @DataProvider(name = "terminosBusqueda")
	public Object[][] provider() {
		return new Object[][] { {"Futbol"},{"Basquetball"},{"Tenis"},{"Golf"},{"Ping Pong"} };
	}
=======

    @DataProvider(name= "Authentication")
	public Object[][] provider(){
		
		LOG.info("Creamos la matriz");
		return new Object[][] {{"Columna de Darwin"},
								{"Triciclos"},
								{"Pistachos"}
								};
	
	}
	
	
	
	@Test(dataProvider = "Authentication")
	public void busquedasGoogle(String a) {
        driver.get("http://google.com.uy");
        
       
        WebElement txtBusqueda= SeleniumUtils.waitUntilClickable(By.name("q"), driver);
        txtBusqueda.sendKeys(a);   
       
                        
	}
	
	@Test
	public void comparoBusquedas() {
		 driver.get("http://google.com.uy");
		 WebElement txtBusqueda= SeleniumUtils.waitUntilClickable(By.name("q"), driver);
		 txtBusqueda.sendKeys("Pistachos");
		 
		 List<WebElement> resultadosGoogle = driver.findElements(By.xpath("//div[@class='rc']/h3[@class='r']/a"));	
	     List<String> auxG = new ArrayList();
	     for(int i=0; i<5; i++) {
	    	 auxG.add(resultadosGoogle.get(i).getText());
	     }
		 //driver.close();
		 
		 driver.get("https://www.bing.com/");
		 WebElement txtBusqueda2= SeleniumUtils.waitUntilClickable(By.name("q"), driver);
		 txtBusqueda2.sendKeys("Pistachos");
		 
		 List<WebElement> resultadosBing = driver.findElements(By.xpath("//div[@class='rc']/h2[@class='r']/a"));
		 List<String> auxB = new ArrayList();
		 for(int i=0; i<5; i++) {
	    	 auxG.add(resultadosGoogle.get(i).getText());
	     }
		 
		 for(int i=0; i<5; i++) {
			 Assert.assertEquals(auxG.get(i)==auxB.get(i), "Comparo Resultados");
			 
		 }
	}

>>>>>>> ac9fe68d19469de7b0751104b21a635b0a4297d2
}





/*
//Registro
WebElement register= driver.findElement(By.linkText("REGISTER"));
register.click();

//Completar Campos
WebElement txtFirstName= driver.findElement(By.name("firstName"));
txtFirstName.sendKeys("Astor");

WebElement txtLastName= driver.findElement(By.name("lasttName"));
txtLastName.sendKeys("Piazzolla");

WebElement submitButton= driver.findElement(By.name("register"));
submitButton.click();
*/