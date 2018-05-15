package hu.course.spring.core.loggers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.course.spring.core.beans.Event;

public class CacheFileEventLogger extends FileEventLogger {

	private int cacheSize;
	private List<Event> cache;

	public CacheFileEventLogger(String fileName, int cacheSize) {
		super(fileName);
		this.cacheSize = cacheSize;
		cache = new ArrayList<>(cacheSize);
	}

	@Override
	public void logEvent(Event event) throws IOException {
		cache.add(event);
		if (cache.size() == cacheSize) {
			writeEventsFromCache();
			cache.clear();
		}
	}

	private void writeEventsFromCache() throws IOException {
		StringBuilder builder = new StringBuilder();
		cache.forEach(event -> {
			builder.append(event.toString());
			builder.append("\n");
		});
		logEvent(builder.toString());
	}

	public void destroy() throws Exception {
		if (!cache.isEmpty()) {
			writeEventsFromCache();
		}
	}
}
