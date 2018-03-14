package training;

import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class ExampleTest {

	private static final Logger LOG = LogManager.getLogger(ExampleTest.class);

	@BeforeClass
	public void beforeC() {
		LOG.info("Al principio");
	}

	@AfterClass
	public void afterC() {
		LOG.info("Al final");
	}

	@BeforeMethod
	public void before() {
		LOG.info("Antes del test");
	}

	@AfterMethod
	public void after() {
		LOG.info("Despues del test");
	}

	@DataProvider(name = "Authentication")
	public Object[][] provider() {
		return new Object[][] { { "testuser_1", "Test@123", "Juan" }, { "testuser_2", "Test@123", "Pedro" } };
	}

	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword, String sName) {
		LOG.info(sUsername);
		LOG.info(sPassword);
		Assert.assertEquals("Juan", sName, "Nombres distintos");
	}

	@Test
	public void metodo() {
		LOG.info("Test 1");
		Assert.fail();
	}

	@Test
	public void metodo2() {
		LOG.info("Test 2");

	}

}