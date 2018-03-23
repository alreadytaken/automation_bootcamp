package Mail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class MailLoginPass {

		private WebDriver driver;
		
		public MailLoginPass(WebDriver driver){
			
			this.driver = driver;
			
			if (!SeleniumUtils.isPresent(By.xpath("//input[@type='password']"), driver)) {
				throw new IllegalStateException("Page did not load");
			}
			
			PageFactory.initElements(driver, this);
		}
	
		
		@FindBy(xpath="//input[@type='password']")
		private WebElement password;
			
		public MailHome typePass(String pass) {
			SeleniumUtils.waitUntilClickable(password, driver);
			this.password.sendKeys(pass);
			this.password.sendKeys(Keys.ENTER);
			return new MailHome(driver);
		}
		
}
