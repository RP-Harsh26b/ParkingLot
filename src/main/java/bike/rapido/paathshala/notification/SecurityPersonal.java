package bike.rapido.paathshala.notification;


import java.util.Observable;

public class SecurityPersonal implements ParkingLotObserver {
    private Boolean isFull;

    public Boolean getFull() {
        return isFull;
    }

    public void setFull(Boolean full) {
        isFull = full;
    }

    public String notifyFull() {
        String message = "Security Personal informed the team about parking lot getting full.";
        System.out.println(message);
        return message;
    }

    public String notifyChangedToNotFull() {
        String message = "Security Personal informed the team about parking lot changing to not full.";
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