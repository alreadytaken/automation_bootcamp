package Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Bandera {
	public String nombre;
	
	public Bandera(WebElement banderaElement) {
		this.nombre = banderaElement.findElement(By.cssSelector("i")).getText();
	}

}
