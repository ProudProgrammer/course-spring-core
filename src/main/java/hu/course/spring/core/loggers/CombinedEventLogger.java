package hu.course.spring.core.loggers;

import java.io.IOException;
import java.util.List;

import hu.course.spring.core.beans.Event;

public class CombinedEventLogger implements EventLogger {

	private List<EventLogger> loggers;

	public CombinedEventLogger(List<EventLogger> loggers) {
		this.loggers = loggers;
	}

	@Override
	public void logEvent(String msg) throws IOException {
		for (EventLogger logger : loggers) {
			logger.logEvent(msg);
		}
	}

	@Override
	public void logEvent(Event event) throws IOException {
		for (EventLogger logger : loggers) {
			logger.logEvent(event);
		}
	}

}
