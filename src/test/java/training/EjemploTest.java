package training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EjemploTest {
	private static final Logger LOG=LogManager.getLogger(EjemploTest.class);
	
	@Test
	public void MetodoEjemplo() {
		LOG.info("Metodoejemplo1 Test");
		//System.out.println("Metodoejemplo1 Test");
	}
	@BeforeMethod
	public void MetodoEjemplo2() {
		LOG.info("Metodoejemplo2 BeforeMethod");
		//System.out.println("Metodoejemplo2 BeforeMethod");
	}
	@AfterMethod
	public void MetodoEjemplo3() {
		LOG.info("Metodoejemplo3 AfterMethod");
		//System.out.println("Metodoejemplo3 AfterMethod");
	}
	@BeforeClass
	public void MetodoEjemplo4() {
		LOG.info("Metodoejemplo4 BeforeClass");
		//System.out.println("Metodoejemplo4 BeforeClass");
	}
	@AfterClass
	public void MetodoEjemplo5() {
		LOG.info("Metodoejemplo5 AfterClass");
		//System.out.println("Metodoejemplo5 AfterClass");
	}
	@Test(dataProvider="Authentication")
	public void MetodoEjemplo6(String sUsername,String sPassword,String sInfo) {
		LOG.info(sUsername);
		LOG.info(sPassword);
		LOG.info(sInfo);
		//System.out.println(sUsername);
		//System.out.println(sPassword);
		//System.out.println(sInfo);
		Assert.assertEquals(sUsername,sInfo,"Verifico los nombres");
		Assert.assertEquals(sUsername,sInfo,"2ndaverif");

	}
	@Test(dataProvider="Authentication")
	public void MetodoEjemplo7(String sUsername,String sPassword,String sInfo) {
		System.out.println(sUsername);
		System.out.println(sPassword);
		System.out.println(sInfo);
		Assert.assertEquals(sUsername,sInfo,"Verifico los nombres");
		Assert.assertEquals("a","b","2ndaverif");
	}
	@DataProvider(name="Authentication")
	public Object[][] provider (){
		return new Object[][] {{"Juan","Test@123","Juan"},{"Juan","Test@123","Pedro"},{"Juan","Test@123","Juan"}};
	}
}

 