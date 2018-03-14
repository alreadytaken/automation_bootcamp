package training;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EjemploTest {
	
	
	private static final Logger LOG=LogManager.getLogger(EjemploTest.class);
	
    @Test
	public void prueba() {
	LOG.info("test");
    }
    @BeforeMethod
    public void pruebabt() {
	System.out.println("Metodo Before test");
		}		
    @AfterMethod
	public void pruebaat() {
	System.out.println("Metodo After test");			
	}
    @BeforeClass
    public void pruebabc() {
	System.out.println("Metodo Before class");
			
}
    @AfterClass
    public void pruebaac() {
	System.out.println("Metodo After class");		
}
    @Test
    public void pruebast() {
	System.out.println("Segundo test");
    }
    @DataProvider(name="Authentication")
    public Object[][] provider(){
    	return new Object [][] {{ "testuser_1", "Test@123","Juan" },{ "testuser_1", "Test@123","Pedro"}};
    	    	
    }
    @Test (dataProvider="Authentication")
    public void test(String sUsername, String sPassword,String sNombre) {
    	System.out.println(sUsername);
    	System.out.println(sPassword);
    	System.out.println(sNombre);
    	Assert.assertEquals(sPassword, sUsername,"Usuario y contraseña");
    	Assert.assertEquals(sUsername, sUsername,"Usuario repetido");
    	
    }
    
    
    
}
