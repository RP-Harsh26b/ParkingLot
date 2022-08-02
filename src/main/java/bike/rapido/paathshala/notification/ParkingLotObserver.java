package bike.rapido.paathshala.notification;


import java.util.Observable;
import java.util.Observer;

public interface ParkingLotObserver extends Observer {

    String notifyFull();

    String notifyChangedToNotFull();

    void update(Observable o, Object isFull);

    default void register(Observable observable) {
        observable.addObserver(this);
    }
}