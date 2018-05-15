package hu.course.spring.core.loggers;

import java.io.IOException;

import hu.course.spring.core.beans.Event;

public interface EventLogger {

	void logEvent(String msg) throws IOException;

	void logEvent(Event event) throws IOException;
}
