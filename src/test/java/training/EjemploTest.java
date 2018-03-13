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
	public void coso() {
		System.out.println("test");
	}
	
	@BeforeMethod
	public void coso2() {
		System.out.println("beforetest");
	}
	
	@AfterMethod
	public void coso3() {
		System.out.println("aftertest");
	}

	@Test
	public void coso4() {
		System.out.println("test");
	}
@BeforeClass
	public void coso5() {
		System.out.println("test beforeclass");
	}
	@AfterClass
	public void coso6() {
	System.out.println("test afterclass");
}
@DataProvider(name= "Authentication")
	public Object[][] provider(){
		
		return new Object[][] {{"Juan", "Pedro"},{"testuser_1", "Test@123"}, {"testuser_1", "Test@123"}, {"Juan", "Pedro"}};
	}
	@Test(dataProvider = "Authentication")
public void test(String sUsername, String sPassword) {
	System.out.println(sUsername);
	System.out.println(sPassword);
	System.out.println("");
	
}
	@Test(dataProvider = "Authentication")
	public void test2(String user, String pass) {
		String user1 = "Juan";
		String pass1 = "Pedro";
		
		Assert.assertTrue((user == user1 && pass == pass1 ), "caso true");
		Assert.assertFalse((user == user1 && pass == pass1 ), "caso false");
		
	}
	
	
	public static void main(String[] args) {
		
	}
	

}
