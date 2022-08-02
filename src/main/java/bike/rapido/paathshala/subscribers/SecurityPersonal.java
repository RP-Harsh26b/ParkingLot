package bike.rapido.paathshala.subscribers;

import bike.rapido.paathshala.parking.ParkingLotObserver;

public class SecurityPersonal implements ParkingLotObserver {
	private boolean parkingLotFull;

	@Override
	public void notifyAllSubscribers() {
		this.parkingLotFull = true;
	}

	public void setParkingLot() {

	}

	public boolean isParkingLotFull() {
		return parkingLotFull;
	}
}
