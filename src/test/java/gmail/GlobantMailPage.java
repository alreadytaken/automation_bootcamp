package gmail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class GlobantMailPage {
	private WebDriver driver;

	public GlobantMailPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.xpath("//span[contains(@class,'bog'])/b"), driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'bog')]/b")
	List<WebElement> list;

	public List<String> getSubjects() {
		List<String> retorno = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 1) {
				List<String> resultados;
			}
		}
		return retorno;
	}
}