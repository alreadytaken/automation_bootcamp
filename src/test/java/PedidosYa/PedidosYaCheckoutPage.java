package PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaCheckoutPage {
	
		private WebDriver driver;
		
		public PedidosYaCheckoutPage(WebDriver driver){
			this.driver = driver;
			
			if (!SeleniumUtils.isPresent(By.xpath("//div[@class='cart-subtitle']/a"), driver)) {
				throw new IllegalStateException("Page did not load");
			}
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(xpath="//div[@class='cart-subtitle']/a")
		private WebElement goingBack;
		
		public 	PedidosYaConfirmPage2 back() {
			this.goingBack.click();
			return new PedidosYaConfirmPage2(driver);
		}
		

}
