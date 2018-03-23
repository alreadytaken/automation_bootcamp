package PedidosYa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaConfirmPage {

	private WebDriver driver;

	public PedidosYaConfirmPage(WebDriver driver) {
		this.driver = driver;
		// a[@class='button']
		if (!SeleniumUtils.isPresent(By.xpath("//div[@class='content_img_most_ordered']"), driver)) {
			throw new IllegalStateException("Page did not load");
		}
		PageFactory.initElements(driver, this);
	}

	private static final Logger LOG;

	static {
		LOG = LogManager.getLogger(PedidosYaTestPage.class);
	}

	@FindBy(xpath = "//*[@id='footerOpen']/a[contains(text(), 'Agregar a mi pedido (')]")
	private WebElement button;

	public String dirConf() {
		String data = driver.findElement(By.xpath("//div[@class='data']/span")).getAttribute("title");
		return data;
	}

	@FindBy(xpath = "//span[@id='scrollContent']//section[@id=' ']/div[@data-auto]")
	private WebElement totalPrice;

	@FindBy(id = "order")
	private WebElement order;

	@FindBy(xpath = "//div[contains(@class, 'top-link')]")
	private WebElement newUser;

	public void validate(String data, String data2) {

		SeleniumUtils.waitUntilClickables(By.id("order"), driver);
		String direccion = dirConf();

		LOG.info("La direccion que se ingreso al principio fue:          " + data);
		LOG.info("La direccion a donde se envia es:            " + direccion);
		LOG.info("El precio que aparece en la publicacion es:        " + data2);
		LOG.info("El precio que aparece en el carrito es:          " + totalPrice.getText());

		// boolean trueDire = direccion.equals(data);
		// boolean truePrice = totalPrice.getText().equals(data2);
	}

	public void confirmPromo() {
		SeleniumUtils.waitUntilClickable(button, driver);
		this.button.click();
	}

	public PedidosYaPopUpPageVIEJA orderFood() {
		SeleniumUtils.waitUntilClickable(order, driver);
		this.order.click();

		return new PedidosYaPopUpPageVIEJA(driver);
	}

	public boolean comparation(String user) {
		// SeleniumUtils.waitUntilClickable(newUser, driver);
		LOG.info(user.equals(newUser.getText()));
		return (user.equals(newUser.getText()));
	}

}