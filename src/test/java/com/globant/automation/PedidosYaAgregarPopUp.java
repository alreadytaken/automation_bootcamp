package com.globant.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaAgregarPopUp {
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//div[@id='footerOpen']//a[@class='button']")
	WebElement agregarButton;
	@FindBy(how = How.XPATH, using = "//div[@id='footerOpen']//a[@class='button']/i")
	WebElement beforeAddingPrice;
	@FindBy(how = How.XPATH, using = "//div[@class='tcontent']//div[@class='info']/h2")
	WebElement beforeAddingNameTag;

	public PedidosYaAgregarPopUp(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.WaitUntilVisibilityList(By.xpath("//div[@id='footerOpen']//a[@class='button']/i"), driver);
		PageFactory.initElements(driver, this);
	}

	public String getPrice() {
		String baP = beforeAddingPrice.getText();
		return baP;
	}

	public String getPlateName() {
		String plateName = beforeAddingNameTag.getText();
		return plateName;
	}

	public CheckingOutPage clickAgregarAlPedido() {
		agregarButton.click();
		return new CheckingOutPage(driver);
	}

}
