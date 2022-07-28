package bike.rapido.paathshala;

import bike.rapido.paathshala.vehicle.Car;

public class Person {

	private final Car car;

	public Person(Car car) {
		this.car = car;
	}

	public Car getCar() {
		return this.car;
	}

	@Override
	public String toString() {
		return "Person{" +
				"car=" + car +
				'}';
	}

	//	public int parkVehicle(Car car) {
//
//	}
}
