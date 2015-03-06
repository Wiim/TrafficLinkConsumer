package EntryPackage;

import Beans.FeatureCollection;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class TrafficLinkCaller {

	public TrafficLinkCaller() {}

	public FeatureCollection getFromTrafficLink() {

		try {
			URL url = new URL("http://www.trafficlink-online.nl/trafficlinkdata/wegdata/TrajectSensorsNH.GeoJSON");
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			try {
				FeatureCollection newCollecion = mapper.readValue(url, FeatureCollection.class);
				return new FeatureCollection(newCollecion.getType(), newCollecion.getFeatures());
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
