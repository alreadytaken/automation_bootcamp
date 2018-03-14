package training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class EjemploTest {
	private static final Logger Log = LogManager.getLogger(EjemploTest.class);
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
	Log.info("Before");
	}
	
	@AfterMethod
	public void test3()
	{
		Log.info("After");
	}
	
	@AfterClass
	public void test4()
	{
		Log.info("AfterClass");
	}
	
	@BeforeClass
	public void test5()
	{
		Log.info("BeforeClass");
	}
	
}
