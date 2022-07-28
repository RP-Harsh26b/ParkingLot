package bike.rapido.paathshala.parking;

import java.util.ArrayList;
import java.util.Collections;

public class VehiclePark {

    private final Integer totalParkingSlots;

    private ParkingSlot emptyParkingSlotObject = new ParkingSlot(false,null);
    private ArrayList<ParkingSlot> parkingSlotList ;
    public VehiclePark(int totalParkingSlots) {
        this.totalParkingSlots = totalParkingSlots;
        parkingSlotList= new ArrayList<ParkingSlot>(Collections.nCopies(totalParkingSlots,emptyParkingSlotObject));
    }

//    public ParkingSlot(int totalParkingSlots) {
//        this.totalParkingSlots = totalParkingSlots;
//    }

    public int getEmptyParkingSlotsCount() {
        return totalParkingSlots;
    }

}
