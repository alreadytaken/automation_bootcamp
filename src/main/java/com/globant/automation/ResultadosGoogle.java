package com.globant.automation;

import org.openqa.selenium.By;

public class ResultadosGoogle {

	
	
	
	public void listaResultados() {
		resG = driver.findElements(By.xpath("//div[@class='rc']/h3/a"));
		}
	
	
}
