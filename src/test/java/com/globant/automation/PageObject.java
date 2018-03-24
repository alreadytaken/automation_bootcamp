package com.globant.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	protected static WebDriver driver;
	
	public PageObject(WebDriver driver){
        PageObject.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
