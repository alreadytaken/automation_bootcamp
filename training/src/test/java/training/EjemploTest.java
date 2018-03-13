package training;

import org.testng.Assert;
import org.testng.annotations.*;

public class EjemploTest {
	@Test(dataProvider = "Authentication")
	public void test1(String sUsername, String sPassword, String sResult )
	{
		Assert.assertFalse(sUsername == sPassword, "estoy comparando1");
		Assert.assertTrue(sUsername == sPassword , "estoy comparando2");
		
		
	}
	@DataProvider(name = "Authentication")
	public Object[][] provider()
	{
		return new Object[][] {{"testuser_1", "Test@123", "result"}, {"testuser_1", "Test@123", "result"}};
	}
	
	@BeforeMethod
	public void test2()
	{
		System.out.println("Before");
	}
	
	@AfterMethod
	public void test3()
	{
		System.out.println("After");
	}
	
	@AfterClass
	public void test4()
	{
		System.out.println("AfterClass");
	}
	
	@BeforeClass
	public void test5()
	{
		System.out.println("BeforeClass");
	}
	
}
