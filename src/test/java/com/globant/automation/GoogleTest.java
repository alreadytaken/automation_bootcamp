package com.globant.automation;

import java.util.ArrayList;
import java.util.List;
import java.net.MalformedURLException;

import javax.xml.xpath.XPath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	public GoogleTest() {

	}

	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}

	/*@DataProvider(name = "Busqueda")
	public Object[][] provider() {
		return new Object[][] { { "Casas" }, { "Autos" }, { "Pepe" }, { "Barcos" }, { "Celulares" } };
	}*/

	/*
	 * @Test(dataProvider = "Busqueda") public void testBusquedaGoogle(String
	 * buscar) { LOG.info("Test busqueda"); driver.get("https://www.google.com/");
	 * //WebElement txtSearch = driver.findElement(By.id("lst-ib")); WebElement
	 * txtSearch = SeleniumUtils.waitUntilClickable(By.id("lst-ib"), driver);
	 * txtSearch.sendKeys(buscar); txtSearch.submit(); //WebElement e = (new
	 * WebDriverWait(driver,
	 * 10)).until(ExpectedConditions.elementToBeClickable(By.name("q")));
	 * //SeleniumUtils.waitUntilClickable(txtSearch, driver); List<WebElement>
	 * resultados = driver.findElements(By.xpath("//h3[@class='r']/a"));
	 * resultados.get(0).click(); }
	 */

	/*@Test(dataProvider = "Busqueda")
	public void testEjercicio(String busqueda) {
		List<String> resultadosGoogle = new ArrayList<String>();
		List<String> resultadosBing = new ArrayList<String>();
		LOG.info("Ejercicio");

		// Prueba con Google
		LOG.info("Entrando a Google");
		driver.get("https://www.google.com/");
		WebElement txtSearch = SeleniumUtils.waitUntilClickable(By.id("lst-ib"), driver);
		txtSearch.sendKeys(busqueda);
		txtSearch.submit();
		List<WebElement> resultados = driver.findElements(By.xpath("//h3[@class='r']/a"));
		for (int i = 0; i < 5; i++) {
			resultadosGoogle.add(resultados.get(i).getText());
		}

		// Prueba con Bing
		LOG.info("Entrango a Bing");
		driver.get("https://www.bing.com/");
		txtSearch = SeleniumUtils.waitUntilClickable(By.id("sb_form_q"), driver);
		txtSearch.sendKeys(busqueda);
		txtSearch.submit();
		resultados = driver.findElements(By.xpath("//li[@class='b_algo']/h2/a"));
		for (int i = 0; i < 5; i++) {
			resultadosBing.add(resultados.get(i).getText());
		}

		// Comparando resultados
		for (int i = 0; i < 5; i++) {
			String resGoogle = resultadosGoogle.get(i);
			String resBing = resultadosBing.get(i);
			LOG.info("Resultado de Google " + i + ": " + resGoogle);
			LOG.info("Resultado de Bing " + i + ": " + resBing);
			if (resGoogle.equals(resBing)) {
				LOG.info("Resultados iguales");
			} else {
				LOG.info("Resultados distintos");
			}
			LOG.info("");

		}
		Assert.assertArrayEquals(resultadosGoogle.toArray(), resultadosBing.toArray());

	}*/

	/*
	 * @Test public void searchTest() throws InterruptedException {
	 * LOG.info("Search test"); driver.get("http://newtours.demoaut.com/");
	 * WebElement txtUsername = driver.findElement(By.name("userName")); WebElement
	 * txtPassword = driver.findElement(By.name("password"));
	 * txtUsername.sendKeys("usuario"); txtPassword.sendKeys("pass"); WebElement
	 * btnLogIn = driver.findElement(By.name("login")); btnLogIn.click(); }
	 */
	
	@DataProvider(name = "Datos newtours")
	public Object[][] provider() {
		return new Object[][] { { "Gonzalo", "Lombardi", "000000000", "asd@asd.com", "Mi casa", "1234", "Montevideo", "Centro", "11200", "Uruguay", "Usuario", "pass", "pass" } };
	}
	
	@Test (dataProvider = "Datos newtours")
	public void testNewtour (String nombre, String apellido, String cel, String mail, String direccion, String direccion2, String ciudad, String barrio, String codigoP, String pais, String user, String pass, String pass2) {
		LOG.info("Entrando a Newtours");
		driver.get("http://newtours.demoaut.com/");
		List<WebElement>botones = driver.findElements(By.xpath("//td[@class='mouseOut']/a"));
		WebElement btnRegistro = botones.get(1);
		btnRegistro.click();
		
		//Relleno datos
		
	}

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("Prepare test");
		// DesiredCapabilities caps = DesiredCapabilities.firefox();
		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps);
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass()
	private void prepareClass() {
		LOG.info("Prepare class");
		// WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
	}
}
