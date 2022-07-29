package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.Person;
import bike.rapido.paathshala.vehicle.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class VehiclePark {

	private final Car testCar = new Car("DL5CQ 0258");
	private final Person testPerson = new Person(testCar, "Harshit");
	private final ParkingSlot emptyParkingSlotObject = new ParkingSlot( );
	private final ParkingSlot fullParkingSlotObject = new ParkingSlot(testCar);
	private Integer totalParkingSlots;
	private ArrayList<ParkingSlot> parkingSlotList;

	public VehiclePark(int totalEmptyParkingSlots) {
		this.totalParkingSlots = totalEmptyParkingSlots;
		parkingSlotList = new ArrayList<ParkingSlot>(Collections.nCopies(totalEmptyParkingSlots, emptyParkingSlotObject));
	}


	// For test use only
	public VehiclePark(int totalParkingSlots, Boolean isFull) {
		if (!isFull) new VehiclePark(totalParkingSlots);
		else {
			this.totalParkingSlots = totalParkingSlots;
			parkingSlotList = new ArrayList<ParkingSlot>(Collections.nCopies(totalParkingSlots, fullParkingSlotObject));
		}
	}

	public int getTotalParkingSlotsCount() {
		return totalParkingSlots;
	}

	public ParkingSlot getEmptyParkingSlot() {

		for (ParkingSlot slot : parkingSlotList) {
			if (slot.getIsEmpty()) return slot;
		}
		return null;

	}

	public ParkingSlot markParked(ParkingSlot receivedEmptyParkingSlot, Car car) {
		for (ParkingSlot slot : parkingSlotList) {
			if (Objects.equals(slot, receivedEmptyParkingSlot) && slot.getIsEmpty()) {
				slot.setCar(car);
				return slot;
			}
		}
		return null;
	}
}