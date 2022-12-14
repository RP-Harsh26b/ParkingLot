package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.vehicle.Car;

public class ParkingSlot {

	private static Integer idCount = 1;

	private final Integer id;
	private Car car;

	public ParkingSlot(final Car car) {
		this.id = getIdCount();
		incrementIdCount();
		this.car = car;
	}

	public ParkingSlot(final Integer id, final Car car) {

		this.id = id;
		this.car = car;
	}

	public ParkingSlot() {
		this.id = getIdCount();
		incrementIdCount();
		this.car = null;
	}

	public static Integer getIdCount() {
		return idCount;
	}

	public static void setIdCount(final Integer idCount) {
		ParkingSlot.idCount = idCount;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(final Car car) {
		this.car = car;
	}

	private void incrementIdCount() {
		setIdCount(getIdCount() + 1);
	}

	public Integer getId() {
		return id;
	}

	public Boolean getIsEmpty() {
		return this.car == null;
	}

	@Override
	public String toString() {
		return "ParkingSlot{" +
			"id=" + id +
			", isEmpty=" + getIsEmpty() +
			", car=" + car +
			'}';
	}
}
