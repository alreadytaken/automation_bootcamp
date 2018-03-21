package TestPedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class PedidosYaHomePage extends PageObject {
@FindBy(how = How.ID, using = "//a[@id='linkUy']")
private WebElement Pais;

public PedidosYaHomePage (WebDriver driver) {
    super(driver);
}

public HomePageUruguay click() {
	Pais.click();
	return new HomePageUruguay(driver);
}
	
}
