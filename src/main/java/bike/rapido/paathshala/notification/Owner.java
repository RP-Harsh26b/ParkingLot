package bike.rapido.paathshala.notification;

public class Owner implements ParkingLotObserver {
    public String notifyFull() {
        return "Owner showed vehicle park full sign.";
    }


}