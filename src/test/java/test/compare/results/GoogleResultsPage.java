package test.compare.results;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultsPage {

	@FindBy(how = How.XPATH, using = "//div[@class='rc']/h3[@class='r']/a")
	List<WebElement> googleResults;
	
	private WebDriver driver;

	public GoogleResultsPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public List<String> ListFirstFive(){
		/*
		 NO GUARDÓ CINCO ELEMENTOS
		List<WebElement> aux = googleResults.subList(0, 5);
		List<String> res = new ArrayList();
		for(WebElement e: aux) {
			res.add(e.getAttribute("innerHTML"));
		}
		return res;
		*/
		List<String> res = new ArrayList();
		for(int i=0; i<=4; i++) {
			res.add(googleResults.get(i).getAttribute("innerHTML"));
			System.out.println("Pasada " + i + " " + res.get(i));
		}
		return res;
	}
}


