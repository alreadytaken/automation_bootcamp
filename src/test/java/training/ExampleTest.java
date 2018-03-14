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
import org.testng.log4testng.Logger;

public class ExampleTest {
	
	private static final Logger LOG = LogManager.getLogger(ExampleTest.class);
	
	
	@BeforeMethod
	public void test0() {
		System.out.println("Beforetest");
	}
	@AfterMethod
	public void test1() {
		System.out.println("Aftertest");
	}
	@Test
	public void test2() {
		System.out.println("test1");
	}
	@BeforeClass
	public void test3() {
		System.out.println("BeforeClass");
	}
	@AfterClass
	public void test4() {
		System.out.println("AfterClass");
	}
	@Test
	public void test5() {
		System.out.println("test2");
	}
	
	@DataProvider (name= "Authentication")
	public static Object[][] credentials(){
		return new Object[][] {{ "testuser_1", "Test@123", "Juan", "Juan" }, { "testuser_2", "Test@123", "Pedro", "Pedro" }};
	}
	
	@Test (dataProvider = "Authentication")
		public void testUno (String sUsername, String sPassword, String sName, String sSurname) {
			System.out.println(sUsername);
			System.out.println(sPassword);
			System.out.print(sName);
			System.out.println(sSurname);
			//Assert.assertEquals(sName, sUsername, "Usuario distinto del nombre");
			Assert.assertEquals(sName, sSurname, "Nombre distinto del apodo");
		}
		
	}
	


