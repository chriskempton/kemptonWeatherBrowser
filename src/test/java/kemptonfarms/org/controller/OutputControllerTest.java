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
public class OutputControllerTest {


	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	private OutputController OutputController;
	public void setOutputController(OutputController c){
		this.OutputController = c;
	}

	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		setOutputController(new OutputController());
	}
	
	@Test
	public void testOutputControllerHTML() {
		ModelAndView mv = OutputController.htmlOutput("48103");
		assertNotNull(mv.getModel().get("forecasts"));
		assertTrue(mv.getModel().get("forecasts") instanceof List);
		List<Forecast> forecasts = (List<Forecast>)mv.getModel().get("forecasts");
		assertTrue(forecasts.size() == 7);
	}
	
	@Test
	public void testOutputControllerXML() {
		ModelAndView mv = OutputController.xmlOutput("48103");
		assertNotNull(mv.getModel().get("forecasts"));
		assertTrue(mv.getModel().get("forecasts") instanceof List);
		List<Forecast> forecasts = (List<Forecast>)mv.getModel().get("forecasts");
		assertTrue(forecasts.size() == 7);
	}
}
