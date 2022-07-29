package bike.rapido.paathshala.vehicle;

public class Car {

	private final String carNumber;

	public Car(String carNumber) {
		this.carNumber = carNumber;
	}

	@Override
	public String toString() {
		return "Car{" +
			"carNumber='" + carNumber + '\'' +
			'}';
	}
}
