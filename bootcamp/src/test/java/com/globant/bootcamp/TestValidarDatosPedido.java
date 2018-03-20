package com.globant.bootcamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;


public class TestValidarDatosPedido {
	
	public TestValidarDatosPedido(){
		
	}

	
private static final Logger LOG;
	
	static {
		LOG = LogManager.getLogger(TestValidarDatosPedido.class);
	}
	
	
	
	
	
	
	
@BeforeMethod
public void prepareTest() {
	
	LOG.info("Preparing");
	
	
}
@AfterMethod
public void cleanup() {
	driver.quit();
}
	
@BeforeClass
private void prepareClass() {
	LOG.info("-----Prepare class-----");
	
	
	WebDriverManager.chromedriver().setup();
	
}		
	
	
	
	
	
	
	
	
}//class
