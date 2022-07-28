package bike.rapido.paathshala.parking;

public class ParkingSlot {
	private int totalParkingSlots;
	public ParkingSlot(int totalParkingSlots) {
		this.totalParkingSlots = totalParkingSlots;
	}

	public int getEmptyParkingSlotsCount() {
		return totalParkingSlots;
	}
}
