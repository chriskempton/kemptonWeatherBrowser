package kemptonfarms.org.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;

import org.cirrostratus.sequoia.featureflags.FeatureFlag;
import org.cirrostratus.sequoia.structuredlogging.DestinationCategory;
import org.cirrostratus.sequoia.structuredlogging.StructuredLogger;
import org.cirrostratus.sequoia.structuredlogging.StructuredLoggerFactory;
import org.cirrostratus.sequoia.watchable.Watchable;
import org.cirrostratus.sequoia.watchable.WatchableListener;
import org.cirrostratus.sequoia.watchable.WatchableRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kemptonfarms.org.model.*;

@Controller
@RequestMapping("/forecasts")
public class MyController implements WatchableListener {
	static final StructuredLogger logger = StructuredLoggerFactory.getLogger(MyController.class, DestinationCategory.DEVELOPMENT);
	
//	private MyServiceWrapper msw;
//	@Autowired
//	public void setMyServiceWrapper(MyServiceWrapper msw){
//		this.msw = msw;
//	}
	
	private WatchableRegistry watchableRegistry;
	@Autowired
	public void setWatchableRegistry(WatchableRegistry wr){
		this.watchableRegistry = wr;
	}
	
	private ExecutorService executorService = null;
	@Autowired
	public void setExecutorService(ExecutorService ex){
		this.executorService = ex;
	}
	
	@PostConstruct
	public void init(){
	}
	
	// trigger is called by subscribing to a watchable
	public void trigger(Watchable watchableKey) {
	}
	
	@RequestMapping(value="/xml/{input}", method={RequestMethod.GET})
	public ModelAndView xmlOutput(@PathVariable("input") String input) {
		return new ModelAndView("xml", getModelMap(input));
	}
	
	@RequestMapping(value="/json/{input}", method={RequestMethod.GET})
	public ModelAndView jsonOutput(@PathVariable("input") String input) {
		return new ModelAndView("json", getModelMap(input));
	}
	
	@RequestMapping(value="/htmltable/{input}", method={RequestMethod.GET})
	public ModelAndView htmlOutput(@PathVariable("input") String input) {
		return new ModelAndView("htmltable", getModelMap(input));
	}	
	
	private static Map<String, Object> getModelMap(String input) {
		String error = "";
		Forecasts forecastsContainer = new Forecasts();
		try {
			forecastsContainer.populate(input);
		} catch (Exception e) {
			error = "Sorry, an error occurred.<br/>" + e.getStackTrace().toString();
		}
		
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("forecasts", forecastsContainer.getItems());
		model.put("error", error);
		model.put("input", input);
		
		return model;
	}
}
