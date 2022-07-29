package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.Person;
import bike.rapido.paathshala.vehicle.Car;

public class ParkingSlot {

	private static Integer idCount = 1;

	private final Integer id;
	private Boolean isEmpty;
	private Car car = null;

	public ParkingSlot(boolean isEmpty, Car car) {

		this.id = getIdCount();
		incrementIdCount();
		this.isEmpty = isEmpty;
		this.car = car;
	}

	public ParkingSlot(Integer id, boolean isEmpty, Car car) {

		this.id = id;
		this.isEmpty = isEmpty;
		this.car = car;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public static Integer getIdCount() {
		return idCount;
	}

	public static void setIdCount(Integer idCount) {
		ParkingSlot.idCount = idCount;
	}

	private void incrementIdCount() {
		setIdCount(getId() + 1);
	}

	public Integer getId() {
		return id;
	}

	public Boolean getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(Boolean empty) {
		isEmpty = empty;
	}


	@Override
	public String toString() {
		return "ParkingSlot{" +
			"id=" + id +
			", isEmpty=" + isEmpty +
			", car=" + car +
			'}';
	}
}