package com.globant.automation.util;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class topComentarios {
	
	WebDriver driver;

	public topComentarios(WebDriver driver) {
		this.driver = driver;
		//SeleniumUtils.waitUntilClickable(By.id("dp-summary-see-all-reviews"), driver);
		//{
			//PageFactory.initElements(driver, this);
		//}
	}
	public imprimir Imprimir() {
		comentarios.click();
		return new topComentarios(driver);
	}
	private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger("");
}
}
