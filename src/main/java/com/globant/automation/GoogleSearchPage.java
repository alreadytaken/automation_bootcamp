package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends GoogleMainPage {

	public GoogleSearchPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h3[@class='r']/a")
	private List<WebElement> resultadosBusqueda = driver.findElements(By.xpath("//h3[@class='r']/a"));

	public List<String> obtenerResultados(int cantidad) {
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < cantidad; i++) {
			ret.add(resultadosBusqueda.get(i).getText());
		}
		return ret;
	}
}
