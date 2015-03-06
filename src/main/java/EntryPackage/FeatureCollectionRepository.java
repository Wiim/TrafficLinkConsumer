package EntryPackage;

import Beans.FeatureCollection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface FeatureCollectionRepository extends CrudRepository<FeatureCollection, Long> {

	List<FeatureCollection> findByType(String type);
}
