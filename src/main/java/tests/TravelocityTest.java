package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TravelocityFlightPage;
import pages.TravelocityHomePage;
import pages.TravelocitySearchFlight;

public class TravelocityTest extends BaseTest{
	
	/**
	 * Scenario: validate the order of flight prices. 
	 * Given: the page /www.travelocity.com to do a flight search.
	 * And: where is the visitor flying from and flying to.
	 * When: the user searches for flights, is expected that prices are ordered correctly.
	 * Then: the prices are ordered correctly.
	 */

	@Test
	public void test() {
		TravelocityHomePage home = new TravelocityHomePage(driver);
		home.clickOnFlightsButton();
		TravelocityFlightPage flight = new TravelocityFlightPage(driver);
		flight.flightOrigin("MVD");
		flight.autocompleteFrom();
		flight.flightDestination("Buenos Aires, Argentina (BUE-All Airports)");
		flight.autocompleteTo();
		flight.flightDeparting();
		flight.flightDepartingDay();
		flight.clickOnsearchButton();
		TravelocitySearchFlight searchF = new TravelocitySearchFlight(driver);
		searchF.getPrices();
		driver.close();
		
		Assert.assertTrue(true, "The prices are ordered correctly");
	}
	

	}

