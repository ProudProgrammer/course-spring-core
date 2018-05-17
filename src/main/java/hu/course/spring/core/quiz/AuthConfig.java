package hu.course.spring.core.quiz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {

	public AuthConfig() {
		System.out.println("AuthConfig created");
	}
	
	@Bean
	AuthBean authBean() {
		return new AuthBean();
	}

}
