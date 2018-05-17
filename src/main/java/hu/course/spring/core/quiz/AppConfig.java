package hu.course.spring.core.quiz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig created");
	}
	
	@Bean
	Service clientService(AuthBean authBean) {
		Service s = new ClientService(authBean);
		return s;
	}

	@Bean
	Service adminService() {
		Service s = new AdminService();
		return s;
	}
}
