package training;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EjemploTest {
	@Test
	public void MetodoEjemplo() {
		System.out.println("Metodoejemplo1 Test");
	}
	@BeforeMethod
	public void MetodoEjemplo2() {
		System.out.println("Metodoejemplo2 BeforeMethod");
	}
	@AfterMethod
	public void MetodoEjemplo3() {
		System.out.println("Metodoejemplo3 AfterMethod");
	}
	@BeforeClass
	public void MetodoEjemplo4() {
		System.out.println("Metodoejemplo4 BeforeClass");
	}
	@AfterClass
	public void MetodoEjemplo5() {
		System.out.println("Metodoejemplo5 AfterClass");
	}
	@Test(dataProvider="Authentication")
	public void MetodoEjemplo6(String sUsername,String sPassword,String sInfo) {
		System.out.println(sUsername);
		System.out.println(sPassword);
		System.out.println(sInfo);
		Assert.assertEquals(sUsername,sInfo,"Verifico los nombres");
		Assert.assertEquals(sUsername,sInfo,"2ndaverif");

	}
	@Test(dataProvider="Authentication")
	public void MetodoEjemplo7(String sUsername,String sPassword,String sInfo) {
		System.out.println(sUsername);
		System.out.println(sPassword);
		System.out.println(sInfo);
		Assert.assertEquals(sUsername,sInfo,"Verifico los nombres");
		Assert.assertEquals(sUsername,sInfo,"2ndaverif");
	}
	@DataProvider(name="Authentication")
	public Object[][] provider (){
		return new Object[][] {{"Juan","Test@123","Juan"},{"Juan","Test@123","Pedro"},{"Juan","Test@123","Juan"}};
	}
}

