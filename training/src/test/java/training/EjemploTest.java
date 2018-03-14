package training;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class EjemploTest {
	
	private static final Logger LOG = LogManager.getLogger(EjemploTest.class);
	//	public EjemploTest() {}
	
	@Test
	public void metodoUno() {
		
		LOG.info("Test Uno");
	
	}

	@Test
	public void metodoDos() {
		LOG.info("Hola");
	
	
	}

	@BeforeMethod
	public void metodoTres() {

		System.out.println("Before Method");
	
	}

	@AfterTest
	public void metodoCuatro() {
		
		System.out.println("After Test");
	
	}
	
	@BeforeClass
	public void metodoCinco() {
		
		System.out.println("Before Class");
	
	}
	
	@AfterClass
	public void metodoSeis() {
		
		System.out.println("After Class");
	
	}
	
	@DataProvider(name= "Authentication")
	public Object[][] provider(){
		
		return new Object[][] {{"testuser_1","Test@123", "res1"},{"testuser_1","Test@123", "res2"}};
	
	}
	
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String password, String otro) {
		sUsername = "Juan";
		password = "Perez";
		otro = password;
		System.out.println(sUsername+ " " + password + "" + otro);
	}
	
	
	@Test(dataProvider = "Authentication")
	public void pruebaAssert(String a, String b, String c) {
		Assert.assertTrue(a != b, a + " distinto de " + b);
		Assert.assertFalse(b == c, a + " igual a " + c);
		
	}
	
	

	

	

}
























/*
       ------- APUNTES DEL MIÉRCOLES 14  ----------
       
       1. Trabajando con Git
       Para hacer un commit en base a un archivo trabajado, se debe:
       
       git add nombreArchivo
       git commit -m "description"
       
		2. WebDriver
		Comunicación código-browser
*/
