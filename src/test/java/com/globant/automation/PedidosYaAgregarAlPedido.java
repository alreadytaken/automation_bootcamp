package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaAgregarAlPedido {
	private WebDriver driver;

	public PedidosYaAgregarAlPedido(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.WaitUntilVisibility(By.xpath(
				"//div/section[@id='resultListContainer']//a[@class='peyaCard js-fp-card']/div[@class='image_product']"),
				driver);
		PageFactory.initElements(driver, this);
	}

	public PedidosYaAgregarPopUp clickearSugerencia(String sugerenciaElegida) {
		WebElement sugerenciaButton = SeleniumUtils.WaitUntilClickable(By
				.xpath("//div/section[@id='resultListContainer']//a[@class='peyaCard js-fp-card'][contains(@data-info,'"
						+ sugerenciaElegida + "')]"),
				driver);
		sugerenciaButton.click();
		return new PedidosYaAgregarPopUp(driver);
	}

}
