package EntryPackage;

import Beans.Feature;
import Beans.FeatureCollection;
import JSONObjects.SpecificRoad;
import JSONObjects.RoadCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class FeatureCollectionController {

	@Autowired
	FeatureCollectionRepository featureCollectionRepository;

	@Autowired
	CollectionSaver collectionSaver;

	@RequestMapping("/database")
	public Iterable<FeatureCollection> featureCollection() {
		Iterable<FeatureCollection> x = featureCollectionRepository.findAll();
		return featureCollectionRepository.findAll();
	}

	@RequestMapping("/road")
	public ArrayList<RoadCollection> specificRoads(@RequestParam(value = "name", required = false, defaultValue = "all") String name) {

		if (!name.equals("all")) {
			Iterable<FeatureCollection> masterList = featureCollectionRepository.findAll();
			Iterator iterator = masterList.iterator();
			ArrayList<RoadCollection> returnList = new ArrayList<>();

			for (FeatureCollection col : masterList) {
//				ArrayList<SpecificRoad> roads = new ArrayList<>();
				RoadCollection roadCollection = new RoadCollection();
				List<Feature> features = col.getFeatures();
				for (Feature f : features) {
					if (f.getProperties().getName().contains(name)) {
						roadCollection.addToList(new SpecificRoad(
										f.getProperties().getName(),
										f.getProperties().getVelocity(),
										f.getProperties().getTraveltime())
						);
					}
				}
				returnList.add(roadCollection);
			}

			return returnList;
		} else {
//			ArrayList<SpecificRoad> roads = new ArrayList<>();
//			roads.add(new SpecificRoad("unkown", -1, -1));
//			ArrayList<ArrayList<SpecificRoad>> returner = new ArrayList<>();
//			returner.add(roads);
//			return returner;
			ArrayList<RoadCollection> roads = new ArrayList<>();
			roads.add(new RoadCollection());
			return roads;
		}
	}
}
