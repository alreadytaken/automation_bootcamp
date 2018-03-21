package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaCountrySelectionPage {
	protected WebDriver driver;

	public PedidosYaCountrySelectionPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "linkUy")
	private WebElement lnkUY;

	public PedidosYaMainPage seleccionarUruguay() {
		lnkUY.click();
		return new PedidosYaMainPage(driver);
	}

}
