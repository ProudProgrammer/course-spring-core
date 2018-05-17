package hu.course.spring.core.aop;

import org.springframework.stereotype.Component;

@Component
public class User {

	public void logEvent(String msg) {
		System.out.println("Message: " + msg);
	}
}
