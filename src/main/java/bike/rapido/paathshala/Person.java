package bike.rapido.paathshala;

import bike.rapido.paathshala.parking.ParkingSlot;
import bike.rapido.paathshala.parking.VehiclePark;
import bike.rapido.paathshala.vehicle.Car;

public class Person {



	private final Car car;
	private final String name;

	public Person(Car car, String name) {
		this.car = car;
		this.name = name;
	}

	public Car getCar() {
		return this.car;
	}

	@Override
	public String toString() {
		return "Person{" +
				"car=" + car +
				", name='" + name + '\'' +
				'}';
	}

	public ParkingSlot parkVehicle(VehiclePark vehiclePark) throws NoEmptyParkingSlotFoundException {

		ParkingSlot emptyParkingSlot = vehiclePark.getEmptyParkingSlot();
		ParkingSlot filledParkingSlot;
		if(emptyParkingSlot!=null){
			filledParkingSlot = vehiclePark.markParked(emptyParkingSlot,this);
		}else{
			throw new NoEmptyParkingSlotFoundException("No Empty Parking Slot Found");
		}
		return filledParkingSlot;

	}

	public static class NoEmptyParkingSlotFoundException extends Exception{
		public NoEmptyParkingSlotFoundException(String message) {
			super(message);
		}
	}
}