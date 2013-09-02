package kemptonfarms.org.api;

import kemptonfarms.org.model.Forecasts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kemptonfarms.org.api.NotFoundException;


/**
 * the forecasts API
 */
@Component
public class ForecastsApiWorker {

  public ForecastsApiWorker(){
    
  }

  /**
   * Run a GET with ZIP code in the path, get output as HTML page
   *
   * 
   * 
   * @return String response
   */
  
  public String htmltable(
    String input
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return null;
  }

  /**
   * Run a GET with ZIP code in the path, get output as JSON array
   *
   * 
   * 
   * @return Forecasts response
   */
  
  public Forecasts json(
    String input
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return getForecasts(input);
  }

  /**
   * Run a GET with ZIP code in the path, get output as XML document
   *
   * 
   * 
   * @return String response
   */
  
  public String xml(
    String input
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return null;
  }

  private static Forecasts getForecasts(String input) {
		String error = "";
		Forecasts forecastsContainer = new Forecasts();
		try {
			forecastsContainer.populate(input);
		} catch (Exception e) {
			error = "Sorry, an error occurred.<br/>" + e.getStackTrace().toString();
		}
		
		return forecastsContainer;
	}

	private static Map<String, Object> getModelMap(String input) {
		Forecasts forecastsContainer = getForecasts(input);
		
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("forecasts", forecastsContainer.getItems());
		model.put("input", input);
		
		return model;
	}

  }

