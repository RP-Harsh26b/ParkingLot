package bike.rapido.paathshala;

import bike.rapido.paathshala.parking.ParkingSlot;
import bike.rapido.paathshala.parking.VehiclePark;
import bike.rapido.paathshala.vehicle.Car;

public class Person {
	private final Car car;
	private final String name;

	public Person(final Car car, final String name) {
		this.car = car;
		this.name = name;
	}

	public Car getCar() {
		return this.car;
	}


	public String getDetails() {
		return "Person{" +
			"car=" + car +
			", name='" + name + '\'' +
			'}';
	}

	public ParkingSlot parkTheCar(final VehiclePark vehiclePark) throws NoEmptyParkingSlotFoundException {

		final ParkingSlot parkingSlot = vehiclePark.getEmptyParkingSlot();
		final ParkingSlot filledParkingSlot;
		if (parkingSlot != null) {
			filledParkingSlot = vehiclePark.markParked(parkingSlot, this.getCar());
		} else {
			throw new NoEmptyParkingSlotFoundException("No Empty Parking Slot Found");
		}
		return filledParkingSlot;

	}

	public ParkingSlot unParkTheCar(final VehiclePark vehiclePark) throws NoEmptyParkingSlotFoundException {
		System.out.println(vehiclePark);
		final ParkingSlot receivedParkedSlot = vehiclePark.getParkingSlotWithVehicle(this.getCar());
		final ParkingSlot receivedEmptyParkingSlot;

		System.out.println(receivedParkedSlot);
		if (receivedParkedSlot == null) {
			throw new NoEmptyParkingSlotFoundException("Could not find the car in VehiclePark");
		} else {
			receivedEmptyParkingSlot = vehiclePark.markUnParked(receivedParkedSlot);
		}
		return receivedEmptyParkingSlot;
	}

	public static class NoEmptyParkingSlotFoundException extends Exception {
		public NoEmptyParkingSlotFoundException(final String message) {
			super(message);
		}
	}

}
