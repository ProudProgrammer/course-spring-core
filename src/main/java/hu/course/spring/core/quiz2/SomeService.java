package hu.course.spring.core.quiz2;

public class SomeService implements InitializingBean, DisposableBean {

	private final SomeComponent component;

	public SomeService(SomeComponent component) {
		this.component = component;
	}

	public void init() {
		System.out.print("a");
	}

	public void close() {
		System.out.print("b");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.print("c");
	}

	@Override
	public void destroy() throws Exception {
		System.out.print("d");
	}

	public void call() {
		component.print();
	}
}
