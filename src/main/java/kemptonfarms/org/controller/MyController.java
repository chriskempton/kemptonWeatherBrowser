package kemptonfarms.org.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.MediaType;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import gov.weather.graphical.dwml.DataType;
import gov.weather.graphical.dwml.Dwml;
import gov.weather.graphical.dwml.ParametersType;
import gov.weather.graphical.dwml.ParametersType.Temperature;
import gov.weather.graphical.dwml.TimeLayoutElementType;

@Controller
@RequestMapping("/temps")
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
	
	private Watchable interestingInternalFeatureOfThisWebapp;
	
	@PostConstruct
	public void init(){
		interestingInternalFeatureOfThisWebapp = watchableRegistry.addIfAbsent(new FeatureFlag(false), "interestingInternalFeatureOfThisWebapp");
		if(interestingInternalFeatureOfThisWebapp == null){
			interestingInternalFeatureOfThisWebapp = watchableRegistry.get(FeatureFlag.class, "interestingInternalFeatureOfThisWebapp");
		}
		interestingInternalFeatureOfThisWebapp.setBit(true);
		interestingInternalFeatureOfThisWebapp.subscribe(this);
	}
	
	// trigger is called by subscribing to a watchable
	public void trigger(Watchable watchableKey) {
		if(interestingInternalFeatureOfThisWebapp != null ){
			boolean fail = interestingInternalFeatureOfThisWebapp.getBit().get();
		}
		
	}
	
	@RequestMapping(value="/html/{input}", method={RequestMethod.GET})
	public ModelAndView htmlOutput(@PathVariable("input") String input) {
		List<String> dates = new ArrayList<String>();
		List<String> min = new ArrayList<String>();
		List<String> max = new ArrayList<String>();
		Dwml entity = getDwml(input);
		for(DataType dt : entity.getData()) {
			for(TimeLayoutElementType times : dt.getTimeLayout()) {
				StringBuilder theTimeRange = new StringBuilder();
				for (Object time : times.getStartValidTimeAndEndValidTime()) {
					theTimeRange.append(time.toString());
					theTimeRange.append(" - ");
				}
				theTimeRange.replace(theTimeRange.length()-3, theTimeRange.length(), "");
				dates.add(theTimeRange.toString());
			}
			for(ParametersType pt : dt.getParameters()) {
				for(Temperature temp : pt.getTemperature()) {
					if(temp.getType().equals("maximum")) {
						max.add(temp.getValue().get(0).getValue().toString());
					} else {
						min.add(temp.getValue().get(0).getValue().toString());
					}
				}
			}
		}
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("dates", dates);
		model.put("max", max);
		model.put("min", min);
		model.put("input", input);
		
		return new ModelAndView("temps", model);
	}
	
	@RequestMapping(value="/view/{input}", method={RequestMethod.GET})
	public ModelAndView viewExample(@PathVariable("input") int input) {
		String transID = UUID.randomUUID().toString();
		
		Map<String, String> model = new HashMap<String,String>();
		model.put("input", new Integer(input).toString());
		model.put("interestingComputation", transID);
		
		return new ModelAndView("example", model);
	}
	
	protected Dwml getDwml(String zip){
		Client client = Client.create();
		WebResource webResource = client.resource("http://graphical.weather.gov/xml/sample_products/browser_interface/ndfdXMLclient.php?whichClient=NDFDgenMultiZipCode&zipCodeList="+zip+"&begin=2013-08-03T00%3A00%3A00&end=2013-08-10T00%3A00%3A00&Unit=e&maxt=maxt&mint=mint");
		ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
		return response.getEntity(Dwml.class);
	}
	
}
