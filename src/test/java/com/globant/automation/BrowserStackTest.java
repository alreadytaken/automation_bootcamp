package com.globant.automation;

import java.net.MalformedURLException; import java.net.URL;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger; import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import org.openqa.selenium.remote.DesiredCapabilities; import org.openqa.selenium.remote.RemoteWebDriver; import org.testng.annotations.AfterMethod; import org.testng.annotations.BeforeClass; import org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;

public class BrowserStackTest {

public static final String USERNAME = "federicomoreira1";
public static final String AUTOMATE_KEY = "vqXXUo8tJ6NyGgzCszUY";
public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
private static final Logger LOG = LogManager.getLogger(BrowserStackTest.class);
private WebDriver driver;

private static DesiredCapabilities caps = new DesiredCapabilities();

@BeforeClass
public void beforeClass() throws MalformedURLException {
    caps.setCapability("browser", "Chrome");
    caps.setCapability("browser_version", "62.0");
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "10");
    caps.setCapability("resolution", "1024x768");
}

@BeforeMethod
public void beforeMethod() throws MalformedURLException {
	LOG.info("Creo el driver");
	driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.facebook.com");
}

@AfterMethod
public void afterMethod() {
	LOG.info("Cierro el driver");
	driver.quit();
}

@Test
public void testBrowserStack() {
	WebElement sName = driver.findElement(By.name("firstname"));
	WebElement sLastName = driver.findElement(By.name("lastname"));
	WebElement sEmail = driver.findElement(By.name("reg_email__"));
	WebElement sPassword = driver.findElement(By.name("reg_passwd__"));
	sName.sendKeys("Mauro");
	sLastName.sendKeys("Mendaro");
	sEmail.sendKeys("mauromendaro@prueba.com");
	sPassword.sendKeys("123456");
    sLastName.submit();

    LOG.info(driver.getTitle());
}
}