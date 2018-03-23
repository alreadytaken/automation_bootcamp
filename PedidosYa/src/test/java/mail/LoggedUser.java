package mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class LoggedUser {

	@FindBy(how = How.XPATH, using = "//td[@class= 'xY a4W']")
	private List<WebElement> subjects;
	
	@FindBy(how = How.XPATH, using ="//div[@id= ':5v']/div/div")
	private WebElement writeEmailButton;
	
	private WebDriver driver;
	
	public LoggedUser(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);

	}
	
	public List<String> getOddSubjects() {
		
		List<String> oddList = new ArrayList();
		int tam = subjects.size();
		for(int i = 0; i<tam; i=i+2) {
			
			oddList.add(subjects.get(i).getText());
		}
		return oddList;
	}
}
