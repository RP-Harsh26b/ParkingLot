package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.vehicle.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class VehiclePark {

	private final Integer totalParkingSlots;
	private final ArrayList<ParkingSlot> parkingSlotList;

	public VehiclePark(final int totalEmptyParkingSlots) {
		this.totalParkingSlots = totalEmptyParkingSlots;
		final ParkingSlot emptyParkingSlotObject = new ParkingSlot();
		parkingSlotList = new ArrayList<>(
				Collections.nCopies(totalEmptyParkingSlots, emptyParkingSlotObject));
	}

	public int getTotalParkingSlotsCount() {
		return totalParkingSlots;
	}

	public ParkingSlot getEmptyParkingSlot() {

		for (final ParkingSlot slot : parkingSlotList) {
			if (slot.getIsEmpty())
				return slot;
		}
		return null;
	}

	public ArrayList<ParkingSlot> getParkingSlotList() {
		return parkingSlotList;
	}

	public ParkingSlot getParkingSlotWithVehicle(final Car car) {

		for (final ParkingSlot slot : parkingSlotList) {
			if ((slot.getCar() != null) && (slot.getCar().equals(car))) {
				return slot;
			}
		}
		return null;

	}

	public ParkingSlot markParked(final ParkingSlot emptyParkingSlot, final Car car) {
		for (final ParkingSlot slot : parkingSlotList) {
			if (Objects.equals(slot, emptyParkingSlot) && slot.getIsEmpty()) {
				slot.setCar(car);
				return slot;
			}
		}
		return null;
	}

	public ParkingSlot markUnParked(final ParkingSlot fullParkingSlot) {
		for (final ParkingSlot slot : parkingSlotList) {
			if (Objects.equals(slot, fullParkingSlot)) {
				slot.setCar(null);
				return slot;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "VehiclePark{" +
				", totalParkingSlots=" + totalParkingSlots +
				", parkingSlotList=" + parkingSlotList +
				'}';
	}

	public Boolean getIsFull() {
		for (ParkingSlot slot : parkingSlotList) {
			if (slot.getIsEmpty()) {
				return false;
			}
		}
		return true;
	}
}