package JSONObjects;

public class SpecificRoad {

	private String road;
	private int velocity;
	private int travelTime;

	public SpecificRoad() {}

	public SpecificRoad(String road, int velocity, int travelTime) {
		this.road = road;
		this.velocity = velocity;
		this.travelTime = travelTime;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int travelTime) {
		this.travelTime = travelTime;
	}
}
