package hu.course.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		app = (App) ctx.getBean("app");

		app.logEvent("Some event for user 2");
		
		((ConfigurableApplicationContext)ctx).close();
	}

	public void logEvent(String msg) {
		String message = msg.replace(client.getId(), client.getFullName());
		eventLogger.logEvent(message);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ConsoleEventLogger getEventLogger() {
		return eventLogger;
	}

	public void setEventLogger(ConsoleEventLogger eventLogger) {
		this.eventLogger = eventLogger;
	}

}