package hu.course.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Truck {

	@Value("Scania")
	private String brand;

	@Value("R")
	private String type;

	@Value("450")
	private int horsePower;

	public Truck() {
	}

	public Truck(String brand, String type, int horsePower) {
		this.brand = brand;
		this.type = type;
		this.horsePower = horsePower;
	}

	@Override
	public String toString() {
		return "Truck [brand=" + brand + ", type=" + type + ", horsePower=" + horsePower + "]";
	}

}
