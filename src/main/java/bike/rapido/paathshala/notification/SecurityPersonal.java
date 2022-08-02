package bike.rapido.paathshala.notification;

public class SecurityPersonal implements ParkingLotObserver {
    public String notifyFull() {
        return "Security Personal informed the team about parking lot getting full.";
    }
}