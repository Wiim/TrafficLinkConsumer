package JSONObjects;

import java.util.ArrayList;

/**
 * Created by wimlustenhouwer on 04-03-15.
 */
public class RoadCollection {

	private ArrayList<SpecificRoad> specificRoads;

	public RoadCollection() {
		specificRoads = new ArrayList<>();
	}

	public ArrayList<SpecificRoad> getSpecificRoads() {
		return specificRoads;
	}

	public void setSpecificRoads(ArrayList<SpecificRoad> specificRoads) {
		this.specificRoads = specificRoads;
	}

	public void addToList(SpecificRoad specificRoad) {
		this.specificRoads.add(specificRoad);
	}
}
