package kemptonfarms.org.model;

import gov.weather.graphical.dwml.DataType;
import gov.weather.graphical.dwml.Dwml;
import gov.weather.graphical.dwml.ParametersType;
import gov.weather.graphical.dwml.TempValType;
import gov.weather.graphical.dwml.TimeLayoutElementType;
import gov.weather.graphical.dwml.ParametersType.Temperature;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Forecasts {
	private static final String weatherUrl = "http://graphical.weather.gov/xml/sample_products/browser_interface/ndfdXMLclient.php?whichClient=NDFDgenMultiZipCode&zipCodeList=%s&Unit=e&maxt=maxt&mint=mint";
    private List<Forecast> items = new ArrayList<Forecast>();

	public List<Forecast> getItems() {
		return items;
	}
	
	public void setItems(List<Forecast> items) {
		this.items = items;
	}
	
	public void populate(String input) {
		if(input == null || input.length() < 1) {
			return;
		}
		List<String> dates = new ArrayList<String>();
		List<String> min = new ArrayList<String>();
		List<String> max = new ArrayList<String>();
		Dwml entity = getDwml(input);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(DataType dt : entity.getData()) {
			TimeLayoutElementType times = dt.getTimeLayout().get(0);
			for(Object time : times.getStartValidTimeAndEndValidTime()) {
				if(time instanceof XMLGregorianCalendar) {
					dates.add(sdf.format(((XMLGregorianCalendar) time).toGregorianCalendar().getTime()));
				}
			}			
			for(ParametersType pt : dt.getParameters()) {
				for(Temperature temp : pt.getTemperature()) {
					for(TempValType theValue : temp.getValue()) {
						if(temp.getType().equals("maximum")) {
							max.add(theValue.getValue().toString());
						} else {
							min.add(theValue.getValue().toString());
						}
					}
				}
			}
		}
		int i = 0;
		int dayRecordCount = Math.min(dates.size(), Math.min(max.size(), min.size()));
		while (i < dayRecordCount) {
			Forecast line = new Forecast();
			line.setDate(dates.get(i));
			line.setHigh(max.get(i));
			line.setLow(min.get(i));
			items.add(line);
			i++;
		}
	}

	protected Dwml getDwml(String zip){
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(String.format(weatherUrl, zip));
			ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
			return response.getEntity(Dwml.class);
		} catch (Exception e) {
			// If any exceptions result while getting the data from NOAA, return an empty Dwml object
			// TODO Report errors to client
			return new Dwml();
		}
	}
}