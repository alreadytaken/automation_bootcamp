package training;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestingTest {
	@DataProvider(name = "Authentication")
	public Object[][] provider(){
		return new Object[][] {{"testuser_1","Test@123","Juan"},{"testuser_2","test@123","Pedro"}};	
	}
	@BeforeClass
	public void testmethod5() {
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void testmethod3() {
		System.out.println("Before Test");
	}
	@Test(dataProvider ="Authentication")
	public void testmethod(String sUsername, String sPassword,String sName) {
		System.out.println(sUsername);
		System.out.println(sPassword);
		System.out.println(sName);
		Assert.assertEquals(sName, "Pedro");
		Assert.assertTrue(sUsername=="testuser_1", "Verificando que username sea testuser_1");
		
	}

	@AfterMethod
	public void testmethod4() {
		System.out.println("After Test");
	}

	@AfterClass
	public void testmethod6() {
		System.out.println("After Class");
	}
}
