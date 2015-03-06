package Beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@Entity
@Table(name = "featurecollection")
public class FeatureCollection implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("features")
	@OneToMany(cascade = CascadeType.ALL)
	@OrderColumn
	private List<Feature> features = new ArrayList<Feature>();

	protected FeatureCollection() {}

	public FeatureCollection(FeatureCollection col) {
		this.type = col.type;
		this.features = col.getFeatures();
	}

	public FeatureCollection(String type, List<Feature> features) {
		this.type = type;
		this.features = features;
	}

	public long getId() {
		return id;
	};

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public List<Feature> getFeatures() {
		return features;
	}
}
