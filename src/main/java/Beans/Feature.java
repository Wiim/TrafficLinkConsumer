package Beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Feature implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(optional = true)
	@OrderBy
	@JoinColumn(name = "collection")
	private FeatureCollection collection;

	@JsonProperty("type")
	private String type;

	@JsonProperty("Id")
	private String descriptor;

	@JsonProperty("geometry")
	private Geometry geometry;

	@JsonProperty("properties")
	private Properties properties; //properties

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
