package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.Person;
import bike.rapido.paathshala.vehicle.Car;

public class ParkingSlot {

	private static Integer idCount = 1;

	private Integer id = null;
	private Car car = null;

	public ParkingSlot( Car car) {

		this.id = getIdCount();
		incrementIdCount();
		this.car = car;
	}

	public ParkingSlot(Integer id, Car car) {

		this.id = id;
		this.car = car;
	}

	public ParkingSlot() {
		this.car = null;
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
		if(this.car!=null) return false;
		else return true;
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