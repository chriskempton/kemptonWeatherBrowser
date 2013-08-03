package kemptonfarms.org.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
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
	
	@RequestMapping(value="/simple/{input}", method={RequestMethod.GET})
	public @ResponseBody String simpleExample(@PathVariable("input") int input) {
		String transID = UUID.randomUUID().toString();
		
		return interestingComputation(input, transID);
	}
	
	@RequestMapping(value="/view/{input}", method={RequestMethod.GET})
	public ModelAndView viewExample(@PathVariable("input") int input) {
		String transID = UUID.randomUUID().toString();
		
		Map<String, String> model = new HashMap<String,String>();
		model.put("input", new Integer(input).toString());
		model.put("interestingComputation", interestingComputation(input,transID));
		
		return new ModelAndView("example", model);
	}
	
	@RequestMapping(value="/asynchronous/{input}", method={RequestMethod.GET})
	@ResponseBody
	public DeferredResult<String> asyncExample(@PathVariable("input") final int input) {
		final DeferredResult<String> deferredResult = new DeferredResult<String>();
		final String transID = UUID.randomUUID().toString();

		Future<Void> future = executorService.submit(new Callable<Void>(){
			public Void call(){
				String returnString = interestingComputation(input, transID); 
				deferredResult.setResult(returnString);
				return null;
			}
		});
		
		return deferredResult;
	}
	
	protected String interestingComputation(int input, String transID){
		if(interestingInternalFeatureOfThisWebapp.getBit().get()){
			return "very interesting! "+input+" "+transID;
		} else {
			return "hm... "+input+" "+transID;
		}
	}
	
}
