package Beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Properties implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonProperty("Timestamp")
	private String timestamp;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Velocity")
	private int velocity;

	@JsonProperty("Length")
	private int length;

	@JsonProperty("Traveltime")
	private int traveltime;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getTraveltime() {
		return traveltime;
	}

	public void setTraveltime(int traveltime) {
		this.traveltime = traveltime;
	}
}
