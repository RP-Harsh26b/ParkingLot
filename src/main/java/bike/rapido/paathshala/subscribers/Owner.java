package bike.rapido.paathshala.subscribers;

import bike.rapido.paathshala.parking.ParkingLotObserver;

public class Owner implements ParkingLotObserver {
	private boolean parkingLotFull;

	@Override
	public void notifySubscriberParkingLotFull() {
		this.parkingLotFull = true;
	}

	@Override
	public void notifySubscriberParkingLotNotFull() {
		this.parkingLotFull = false;
	}

	public void setParkingLot() {

	}

	public boolean isParkingLotFull() {
		return parkingLotFull;
	}
}
