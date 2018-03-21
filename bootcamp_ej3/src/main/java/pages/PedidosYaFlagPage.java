package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import items.Flag;

public class PedidosYaFlagPage {
	private WebDriver driver;

	public PedidosYaFlagPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "li[class='flag']")
	private List<WebElement> flags;

	public int cantidadBanderas() {
		return flags.size();
	}

	public Flag obtenerBandera(int num) {
		Flag ret = new Flag();
		WebElement temp = flags.get(num);
		ret.setName(temp.findElement(By.cssSelector("i")).getText());
		temp = temp.findElement(By.cssSelector("a"));
		ret.setLink(temp.getAttribute("href"));
		return ret;
	}
}
