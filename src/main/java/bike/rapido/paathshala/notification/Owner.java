package bike.rapido.paathshala.notification;

import java.util.Observable;

public class Owner implements ParkingLotObserver {

    private Boolean isFull;


    public void setFull(Boolean full) {
        isFull = full;
    }

    public String notifyFull() {
        String message = "Owner showed vehicle park full sign.";
        System.out.println(message);
        return message;
    }

    @Override
    public String notifyChangedToNotFull() {
        String message = "Owner removed the vehicle park full sign.";
        System.out.println(message);
        return message;
    }

    @Override
    public void update(Observable o, Object isFull) {
        this.setFull((Boolean) isFull);
        if (this.isFull) {
            notifyFull();
        } else {
            notifyChangedToNotFull();
        }
    }

}