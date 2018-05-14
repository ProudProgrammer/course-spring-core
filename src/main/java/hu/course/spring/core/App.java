package hu.course.spring.core;

import hu.course.spring.core.beans.Client;
import hu.course.spring.core.loggers.ConsoleEventLogger;

public class App {

	private Client client;
	private ConsoleEventLogger eventLogger;

	public static void main(String[] args) {
		App app = new App();

		app.client = new Client("1", "John Smith");
		app.eventLogger = new ConsoleEventLogger();

		app.logEvent("Some event for user 1");
	}

	public void logEvent(String msg) {
		String message = msg.replace(client.getId(), client.getFullName());
		eventLogger.logEvent(message);
	}

}