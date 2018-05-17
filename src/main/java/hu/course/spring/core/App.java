package hu.course.spring.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hu.course.spring.core.beans.Client;
import hu.course.spring.core.beans.Event;
import hu.course.spring.core.beans.Trucker;
import hu.course.spring.core.loggers.CacheFileEventLogger;
import hu.course.spring.core.loggers.CombinedEventLogger;
import hu.course.spring.core.loggers.ConsoleEventLogger;
import hu.course.spring.core.loggers.EventLogger;
import hu.course.spring.core.loggers.FileEventLogger;
import hu.course.spring.core.types.EventType;

@Configuration
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
		app.defaultLogger = new CacheFileEventLogger("src/main/resources/logfile.txt", 3);
		app.loggers = new HashMap<>();
		app.loggers.put(EventType.INFO, new ConsoleEventLogger());
		app.loggers.put(EventType.ERROR, new CombinedEventLogger(
				Arrays.asList(new ConsoleEventLogger(), new FileEventLogger("src/main/resources/logfile.txt"))));

		app.logEvent(EventType.ERROR, "Some event for user 1");

		try (ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml")) {
			app = (App) ctx.getBean("app");

			app.logEvent(null, "Some event for user 2");
			app.logEvent(app.event);

			System.out.println(app.client);

			Trucker trucker = (Trucker) ctx.getBean("trucker");
			System.out.println(trucker);
		}

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class)) {
			ctx.scan("hu.course.spring.core");
			Trucker trucker = ctx.getBean(Trucker.class);
			System.out.println(trucker);
		}
	}

	public void logEvent(EventType type, String msg) throws Exception {
		EventLogger logger = loggers.get(type);
		if (logger == null) {
			logger = defaultLogger;
		}
		logger.logEvent(msg);
	}

	public void logEvent(Event event) throws Exception {
		logEvent(event.getEventType(), event.toString());
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}