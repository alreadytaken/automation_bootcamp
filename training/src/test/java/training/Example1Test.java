package training;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Example1Test {
	@BeforeClass
	public void BeforeClass() {
		System.out.println("Principio");
	}
	@BeforeMethod
	public void BeforeTest() {
		System.out.println("BeforeTest");
	}
	@AfterClass
	public void AfterClass() {
		System.out.println("Final");
	}
	@AfterMethod
	public void AfterTest() {
		System.out.println("AfterTest");
	}
		
	@DataProvider(name ="Authentication")
	public static Object [][]credentials(){ 
		return new Object[][] {{ "testuser_1", "Test@123", "Juan"},{"testuser_2", "Test@123", "Pedro"}};
	}
	
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword, String sName) {
		System.out.println(sUsername);
		System.out.println(sPassword);
		System.out.println(sName);
		Assert.assertEquals(sUsername, "testuser_1","Valor Username and testuser_1 are the same");
		
	}
	
	@Test
	public void metodo1() {
	System.out.println("Test1");
	}
	@Test
	public void metodo2() {
	System.out.println("Test2");
	}
}
