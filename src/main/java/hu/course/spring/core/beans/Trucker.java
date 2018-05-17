package hu.course.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Trucker {

	@Value("John Rambo")
	private String name;

	@Autowired
	private Truck truck;

	public Trucker() {
	}

	public Trucker(String name, Truck truck) {
		this.name = name;
		this.truck = truck;
	}

	@Override
	public String toString() {
		return "Trucker [name=" + name + ", truck=" + truck + "]";
	}
}
