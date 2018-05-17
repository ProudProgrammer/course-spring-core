package hu.course.spring.core.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
@Configuration
public class QuizApp {

	@Autowired
	@Qualifier("clientService")
	private Service service;
	
	public QuizApp() {
		System.out.println("QuizApp created");
	}

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(QuizApp.class)) {
			QuizApp app = ctx.getBean(QuizApp.class);
			System.out.println(app.service.greeting());
			System.out.println(((ClientService) app.service).getAuthBean().authMessage());
		}

		try (ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("quiz.xml")) {
			A a1 = (A) ctx.getBean("a");
			B b1 = (B) ctx.getBean("b");
			A a2 = (A) ctx.getBean("a");
			B b2 = (B) ctx.getBean("b");
		}
	}
}
