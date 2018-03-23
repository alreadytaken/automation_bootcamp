package PedidosYa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaConfirmPage2 {

	private WebDriver driver;

	public PedidosYaConfirmPage2(WebDriver driver) {
		this.driver = driver;

		if (!SeleniumUtils.isPresent(By.id("order"), driver)) {
			throw new IllegalStateException("Page did not load");
		}
		PageFactory.initElements(driver, this);
	}

	private static final Logger LOG;

	static {
		LOG = LogManager.getLogger(PedidosYaTestPage.class);
	}

	@FindBy(xpath = "//span[@id='scrollContent']//section[@id=' ']/div[@data-auto]")
	private WebElement totalPrice;

	@FindBy(id = "order")
	private WebElement order;

	@FindBy(xpath = "//div[contains(@class, 'top-link')]")
	private WebElement newUser;

	public PedidosYaPopUpPageVIEJA orderFood() {
		SeleniumUtils.waitUntilClickable(order, driver);
		this.order.click();
		return new PedidosYaPopUpPageVIEJA(driver);
	}

	public boolean comparation(String user) {
		
		LOG.info("El email que ingresamos fue:          "+user);
		LOG.info("El usuario una vez logueado es:         "+newUser.getText());
		return (user.equals(newUser.getText()));
	}
}