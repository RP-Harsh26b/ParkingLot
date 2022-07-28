package bike.rapido.paathshala;

import bike.rapido.paathshala.vehicle.Car;

public class Person {

	private Car car;

	public Person(Car car) {
		this.car = car;
	}

	public Car getCar() {
		return this.car;
	}

	public Boolean parkVehicle() {
		return true;
	}
}
