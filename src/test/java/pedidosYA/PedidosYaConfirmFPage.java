package pedidosYA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaConfirmFPage {
	private WebDriver driver;
	
	public PedidosYaConfirmFPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.className("button"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"footerOpen\"]/a")
	private WebElement confirmPedido;
	
	public void confirmPromo(WebDriver driver) {
		SeleniumUtils.waitUntilClickable(By.className("tinner"), driver);
		SeleniumUtils.waitUntilClickable(By.className("button"), driver);

		confirmPedido.click();
	}
}
