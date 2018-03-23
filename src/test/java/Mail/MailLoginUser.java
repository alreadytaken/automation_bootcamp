package Mail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class MailLoginUser {

		private WebDriver driver;
		
		public MailLoginUser(WebDriver driver){
			
			this.driver = driver;
			
			if (!SeleniumUtils.isPresent(By.xpath("//input[@type='email']"), driver)) {
				throw new IllegalStateException("Page did not load");
			}
			
			PageFactory.initElements(driver, this);
		}
	
		@FindBy(xpath="//input[@type='email']")
		private WebElement email;
				
		public MailLoginPass typeUser(String user) {
			SeleniumUtils.waitUntilClickable(email, driver);
			this.email.sendKeys(user);
			this.email.sendKeys(Keys.ENTER);
			return new MailLoginPass(driver);
		}
		
			
}
