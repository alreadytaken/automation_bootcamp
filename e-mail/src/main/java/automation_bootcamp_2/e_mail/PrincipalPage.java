package automation_bootcamp_2.e_mail;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PrincipalPage {

	public WebDriver driver;

	private static final Logger LOG;

	static {
		LOG = LogManager.getLogger(PrincipalPage.class);
	}

	public PrincipalPage(WebDriver driver) {
		this.driver = driver;

		if (!SeleniumUtils.isPresent(By.xpath("//span[@class = \"bog\"]/b"), driver)) {
			throw new IllegalStateException("Page did not load.");
		}

		PageFactory.initElements(driver, this);
	}

	public void ListaElementos() {

		List<WebElement> ListaSubjetcsTotal;
		List<String> ListaSubjectsTotalString = new ArrayList<String>();
		LOG.info("coso");
		ListaSubjetcsTotal = driver.findElements(By.xpath("//span[@class = \"bog\"]/b"));
		
		LOG.info(ListaSubjetcsTotal.size());
		
		for (int i = 0; i < ListaSubjetcsTotal.size(); i = i + 2) {
			LOG.info("coso2");
			ListaSubjectsTotalString.add(ListaSubjetcsTotal.get(i).getText());

		}

		for (int i = 0; i < ListaSubjectsTotalString.size(); i++) {
			LOG.info("Entra imprimir");
			LOG.info(+i + ":" + ListaSubjectsTotalString.get(i));

		}

	}

}// class