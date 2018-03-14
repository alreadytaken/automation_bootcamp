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
	LOG.info("Metodo Before test");
		}		
    @AfterMethod
	public void pruebaat() {
	LOG.info("Metodo After test");			
	}
    @BeforeClass
    public void pruebabc() {
	LOG.info("Metodo Before class");
			
}
    @AfterClass
    public void pruebaac() {
	LOG.info("Metodo After class");		
}
    @Test
    public void pruebast() {
	LOG.info("Segundo test");
    }
    @DataProvider(name="Authentication")
    public Object[][] provider(){
    	return new Object [][] {{ "testuser_1", "Test@123","Juan" },{ "testuser_1", "Test@123","Pedro"}};
    	    	
    }
    @Test (dataProvider="Authentication")
    public void test(String sUsername, String sPassword,String sNombre) {
    	LOG.info(sUsername);
    	LOG.info(sPassword);
        LOG.info(sNombre);
    	Assert.assertEquals(sPassword, sPassword,"Usuario y contraseña");
    	Assert.assertEquals(sUsername, sUsername,"Usuario repetido");
    	
    }
    
    
    
}
