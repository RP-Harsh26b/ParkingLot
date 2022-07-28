package bike.rapido.paathshala.vehicle;

public class Car {

	private String carNumber;

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

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
