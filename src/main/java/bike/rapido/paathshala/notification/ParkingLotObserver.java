package bike.rapido.paathshala.notification;

import bike.rapido.paathshala.parking.VehiclePark;

public interface ParkingLotObserver {
    String notifyFull();

    default void register(VehiclePark vehiclePark) {
        vehiclePark.register(this);
    }

    default void unRegister(VehiclePark vehiclePark) {
        vehiclePark.unRegister(this);
    }
}