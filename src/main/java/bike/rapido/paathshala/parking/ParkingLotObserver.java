package bike.rapido.paathshala.parking;

public interface ParkingLotObserver {
	void notifySubscriberParkingLotFull();

	void notifySubscriberParkingLotNotFull();
}
