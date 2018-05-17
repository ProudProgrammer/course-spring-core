package hu.course.spring.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* *.logEvent(..))")
	public void allLogEventMethods() {
	}

	@Before("execution(* *.logEvent(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before: " + joinPoint.getTarget().getClass().getSimpleName());
	}

	@After("hu.course.spring.core.aop.LoggingAspect.allLogEventMethods()")
	public void after() {
		System.out.println("Executed");
	}

}
