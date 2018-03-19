package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleResults extends GoogleHome {
	
	WebDriver driver;
	//Defino la lista searchResults en la clase para poder tener acceso a traves de todos los metodos
	private List<String> searchResults = new ArrayList<>();

	public GoogleResults(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//h3[@class='r']/a")
	private List <WebElement> searchResultsWebElements;
	
	
	public void saveResults(){
		for(WebElement result: searchResultsWebElements) {
			searchResults.add(result.getText());		
		}
	}
	
	public List<String> getResults(int cant){
		saveResults();
		List <String> aux = new ArrayList<>();
		for( int i = 0; i<cant;i++) {
			aux.add(searchResults.get(i));
		}
		return aux;
	}
	
	
	


}
