package hu.course.spring.core.quiz;

public class AuthBean {

	public AuthBean() {
		System.out.println("AuthBean created");
	}
	
	public String authMessage() {
		return "Authenticated";
	}
}
