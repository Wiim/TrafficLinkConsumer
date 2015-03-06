package Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Geometry implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;

	@JsonProperty("type")
	private String type;

	@JsonIgnore
	@JsonProperty("coordinates")
	private String coordinates;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public String getCoordinates() {
//		return coordinates;
//	}

//	public void setCoordinates(String coordinates) {
//		this.coordinates = coordinates;
//	}
}
