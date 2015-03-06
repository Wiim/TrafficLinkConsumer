package EntryPackage;

import Beans.FeatureCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@EnableAutoConfiguration
@Component
public class CollectionSaver {

	@Autowired
	TrafficLinkCaller caller;

	@Autowired
	FeatureCollectionRepository featureCollectionRepository;

	protected CollectionSaver() {}

	private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

	public CollectionSaver getInstance() {
		return this;
	}

	public String runScheduling() {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
		RecordingRetrieveRunnable runner = new RecordingRetrieveRunnable();

		if (executor.getQueue().isEmpty()) {
			executor.schedule(runner, 1, TimeUnit.SECONDS);
		}

		return "Schedule started";
	}

	private class RecordingRetrieveRunnable implements Runnable {

		public void run() {
			setFeatureCollection();
		}
	}

	private void setFeatureCollection() {
		RecordingRetrieveRunnable runner = new RecordingRetrieveRunnable();
		featureCollectionRepository.save(new FeatureCollection(caller.getFromTrafficLink()));
		executor.schedule(runner, 300, TimeUnit.SECONDS);
	}
}