package training;

import org.testng.annotations.*;
import org.testng.Assert;

public class ExampleTest {

	@BeforeClass
	public void beforeC() {
		System.out.println("Al principio");
	}

	@AfterClass
	public void afterC() {
		System.out.println("Al final");
	}

	@BeforeMethod
	public void before() {
		System.out.println("Antes del test");
	}

	@AfterMethod
	public void after() {
		System.out.println("Despues del test");
	}

	@DataProvider(name = "Authentication")
	public Object[][] provider() {
		return new Object[][] { { "testuser_1", "Test@123", "Juan" }, { "testuser_2", "Test@123", "Pedro" } };
	}

	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword, String sName) {
		System.out.println(sUsername);
		System.out.println(sPassword);
		Assert.assertEquals("Juan", sName, "Nombres distintos");
	}

	@Test
	public void metodo() {
		System.out.println("Test 1");
		Assert.fail();
	}

	@Test
	public void metodo2() {
		System.out.println("Test 2");
		
	}

}