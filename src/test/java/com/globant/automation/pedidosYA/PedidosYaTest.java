package pedidosYA;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pedidosYA.PedidosYaConfirmPage;
public class PedidosYaTest {
	private static final Logger LOG;
	static {
		LOG = LogManager.getLogger(PedidosYaTest.class);
	}
	protected static WebDriver driver;

	/*@DataProvider(name = "Pedido")
	public Object[][] provider() {
		return new Object[][] { { "Nicaragua 1666" }, { "milanesa" } };
	}*/

	@BeforeClass
	public void prepareClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeMethod
	public void prepareTest() {
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}

	@Test //(dataProvider ="Pedido")
	public void ofertasTest() {
		driver.manage().window().maximize();
		driver.get("https://www.pedidosya.com");
		PedidosYaHomePage homePage = new PedidosYaHomePage(driver);
		homePage.enter(driver);
		PedidosYaHomePageUY homePageUY = new PedidosYaHomePageUY(driver);
		homePageUY.enterInfo("Nicaragua 1666","milanesa");
		PedidosYaConfirmPage confirmPage = new PedidosYaConfirmPage(driver);
		confirmPage.confirmEnter(driver);
		PedidosYaPromoPage promoPage = new PedidosYaPromoPage (driver);
		promoPage.promoEnter(driver);
		PedidosYaConfirmFPage confirmFPage = new PedidosYaConfirmFPage (driver);
		confirmFPage.confirmPromo(driver);
		PedidosYaFoodPage confirmPedido = new PedidosYaFoodPage (driver);
		confirmPedido.confirmPedido(driver);
		PedidosYaLogInPage login = new  PedidosYaLogInPage (driver);
		login.LogIn("miEjemploGlobant@gmail.com", "kesmaneskesman");
		PedidosYaModPedido modPedido = new PedidosYaModPedido (driver);
		modPedido.modPedido();
		
	}
}