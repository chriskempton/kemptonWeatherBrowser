package kemptonfarms.org.controller;

import static org.junit.Assert.*;

import java.util.List;

import kemptonfarms.org.model.Forecast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-context.xml"})
public class MyControllerTest {


	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	private MyController myController;
	public void setMyController(MyController c){
		this.myController = c;
	}

	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		setMyController(new MyController());
	}
	
	@Test
	public void testMyControllerHTML() {
		ModelAndView mv = myController.htmlOutput("48103");
		assertNotNull(mv.getModel().get("forecasts"));
		assertTrue(mv.getModel().get("forecasts") instanceof List);
		List<Forecast> forecasts = (List<Forecast>)mv.getModel().get("forecasts");
		assertTrue(forecasts.size() == 7);
	}
	
	@Test
	public void testMyControllerXML() {
		ModelAndView mv = myController.xmlOutput("48103");
		assertNotNull(mv.getModel().get("forecasts"));
		assertTrue(mv.getModel().get("forecasts") instanceof List);
		List<Forecast> forecasts = (List<Forecast>)mv.getModel().get("forecasts");
		assertTrue(forecasts.size() == 7);
	}
	
	
	@Test
	public void testMyControllerJson() {
		ModelAndView mv = myController.jsonOutput("48103");
		assertNotNull(mv.getModel().get("forecasts"));
		assertTrue(mv.getModel().get("forecasts") instanceof List);
		List<Forecast> forecasts = (List<Forecast>)mv.getModel().get("forecasts");
		assertTrue(forecasts.size() == 7);
	}
}
