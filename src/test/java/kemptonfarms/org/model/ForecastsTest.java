package kemptonfarms.org.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class ForecastsTest {

	Forecasts theForecasts;
	
	@Before
	public void setup() {
		theForecasts = new Forecasts();
	}
	
	@Test
	public void testPopulateRealZIP() {
		// Try Ann Arbor ZIP
		theForecasts.populate("48104");
		
		// Depending on time of day, the service will return 6 or 7 complete Forecasts
		System.out.println("Forecasts found: " + theForecasts.getItems().size());
		assertTrue(theForecasts.getItems().size() > 5);
		assertTrue(theForecasts.getItems().size() < 8);
	}
	
	@Test
	public void testPopulateEmptyZIP() {
		// Try empty ZIP input
		theForecasts.populate("");
		assertTrue(theForecasts.getItems().size() == 0);
	}
	
	@Test
	public void testPopulateNonsenseZIP() {
		// Try empty ZIP input
		theForecasts.populate("Chris");
		assertTrue(theForecasts.getItems().size() == 0);
	}
	
	@Test
	public void testPopulateNullZIP() {
		// Try empty ZIP input
		theForecasts.populate(null);
		assertTrue(theForecasts.getItems().size() == 0);
	}

}
