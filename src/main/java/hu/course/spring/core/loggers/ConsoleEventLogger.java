package hu.course.spring.core.loggers;

import hu.course.spring.core.beans.Event;

public class ConsoleEventLogger implements EventLogger {

	public void logEvent(String msg) {
		System.out.println(msg);
	}

	public void logEvent(Event event) {
		logEvent(event);
	}
}
