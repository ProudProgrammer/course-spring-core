package hu.course.spring.core.quiz2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizApp2 {

	public static void main(String[] args) {

		ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("quiz2.xml");

		SomeService service = appCtx.getBean(SomeService.class);
		service.call();

		appCtx.close();

	}

}
