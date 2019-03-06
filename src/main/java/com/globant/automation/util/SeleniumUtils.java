package com.globant.automation.util;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumUtils {
	
	public static boolean waitForElementToBeVisible(WebDriver driver, By locator, int espera) {
        return new WebDriverWait(driver, espera).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
            	WebElement e = driver.findElement(locator);
                return e.isDisplayed();
            }
        });
    }

	private static final int TIMEOUT = 20;

	public static WebElement getWebElement(WebDriver driver, By locator) {
		return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static boolean waitForElementToBeVisible(WebElement element,WebDriver driver) {
		return new WebDriverWait(driver, TIMEOUT).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver input) {
				return element.isDisplayed();
			}
					});
	}
			
	
}
			
		
