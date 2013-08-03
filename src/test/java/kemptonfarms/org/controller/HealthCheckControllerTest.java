package kemptonfarms.org.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-context.xml"})
public class HealthCheckControllerTest {


	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	
	@Autowired
	private HealthCheckController hcController;
	public void setHealthCheckController(HealthCheckController c){
		this.hcController = c;
	}

	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}
	
	@Test
	public void testHealthCheckController() throws IOException {
		assertEquals("ok", hcController.healthcheck(response));
		assertEquals(200, response.getStatus());
	}

}
