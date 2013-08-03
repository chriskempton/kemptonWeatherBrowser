package kemptonfarms.org.controller;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

import javax.servlet.http.HttpServletResponse;

import org.cirrostratus.sequoia.servicelocator.ServiceLocator;
import org.cirrostratus.sequoia.structuredlogging.DestinationCategory;
import org.cirrostratus.sequoia.structuredlogging.StructuredLogger;
import org.cirrostratus.sequoia.structuredlogging.StructuredLoggerFactory;
import org.cirrostratus.sequoia.watchable.WatchableRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/healthcheck")
public class HealthCheckController {
	static final StructuredLogger logger = StructuredLoggerFactory.getLogger(HealthCheckController.class, DestinationCategory.DEVELOPMENT);
	
//	private MyServiceWrapper msw;
//	@Autowired
//	public void setMyServiceWrapper(MyServiceWrapper msw){
//		this.msw = msw;
//	}
	
	private ServiceLocator serviceLocator;
	@Autowired
	public void setServiceLocator(ServiceLocator sl){
		this.serviceLocator = sl;
	}
	
	private WatchableRegistry watchableRegistry;
	@Autowired
	public void setWatchableRegistry(WatchableRegistry wr){
		this.watchableRegistry = wr;
	}
	
	protected static ExecutorService executor = null;
	@Autowired
	public void setExecutorService(ExecutorService ex){
		this.executor = ex;
	}
	
	@RequestMapping(value="/", method={RequestMethod.GET})
	public @ResponseBody String healthcheck(HttpServletResponse response) throws IOException {
		if ( serviceLocator != null
//				&& msw != null 
				&& watchableRegistry != null && executor != null) {
			return "ok";
		}
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
				"spring autowiring has failed");
		return null;
	}

}
