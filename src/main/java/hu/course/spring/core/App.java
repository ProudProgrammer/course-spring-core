package hu.course.spring.core;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hu.course.spring.core.beans.Client;
import hu.course.spring.core.beans.Event;
import hu.course.spring.core.loggers.ConsoleEventLogger;
import hu.course.spring.core.loggers.EventLogger;
import hu.course.spring.core.types.EventType;

public class App {

	private Client client;
	private EventLogger defaultLogger;
	private Map<EventType, EventLogger> loggers;
	private Event event;

	public App() {
	}

	public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {
		this.client = client;
		this.defaultLogger = defaultLogger;
		this.loggers = loggers;
	}

	public static void main(String[] args) throws Exception {
		App app = new App();

		app.client = new Client("1", "John Smith");
		app.defaultLogger = new ConsoleEventLogger();

		app.logEvent("Some event for user 1");

		try (ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml")) {
			app = (App) ctx.getBean("app");

			app.logEvent("Some event for user 2");
			app.logEvent(app.event);
		}

	}

	public void logEvent(String msg) throws Exception {
		String message = msg.replace(client.getId(), client.getFullName());
		defaultLogger.logEvent(message);
	}

	public void logEvent(Event event) throws Exception {
		defaultLogger.logEvent(event);
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}