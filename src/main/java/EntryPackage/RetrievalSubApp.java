package EntryPackage;

import Beans.FeatureCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

@EnableAutoConfiguration
@EntityScan(basePackageClasses = FeatureCollection.class)
@SpringBootApplication
public class RetrievalSubApp implements CommandLineRunner {

	@Autowired
	CollectionSaver collectionSaver;

	public void start() {
		SpringApplication.run(RetrievalSubApp.class);
	}

	@Override
	public void run(String... strings) {
		String s = collectionSaver.runScheduling();
	}
}
