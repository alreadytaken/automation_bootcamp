package com.globant.automation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class lentes {
	
	WebDriver driver;

	public lentes(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.id("dp-summary-see-all-reviews"), driver);
		{
			PageFactory.initElements(driver, this);
		}
	}

	@FindBy(how = How.ID, using = "dp-summary-see-all-reviews")
	private WebElement comentarios;
	
	public topComentarios bucarComentarios() {
		comentarios.click();
		return new topComentarios(driver);
	}
}
