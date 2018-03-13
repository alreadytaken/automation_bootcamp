package training;

import org.testng.Assert;
import org.testng.annotations.*;

public class EjemploTest {
	
	
	//	public EjemploTest() {}
	
	@Test
	public void metodoUno() {
		
		System.out.println("Test Uno");
	
	}

	@Test
	public void metodoDos() {
		
		System.out.println("Test Dos");
	
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
