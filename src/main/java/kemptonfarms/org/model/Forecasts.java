package kemptonfarms.org.model;

import java.util.ArrayList;
import java.util.List;

class Forecasts {
   private List<Forecast> items = new ArrayList<Forecast>();

	public List<Forecast> getItems() {
		return items;
	}
	
	public void setItems(List<Forecast> items) {
		this.items = items;
	}
}