package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.Person;
import bike.rapido.paathshala.vehicle.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class VehiclePark {

    private Integer totalParkingSlots;
    private final Person testPerson = new Person(new Car("DL5CQ 0258"), "Harshit");

    private ParkingSlot emptyParkingSlotObject = new ParkingSlot(true,null);
    private ParkingSlot fullParkingSlotObject = new ParkingSlot(false, testPerson);
    private ArrayList<ParkingSlot> parkingSlotList ;

    public VehiclePark(int totalEmptyParkingSlots) {
        this.totalParkingSlots = totalEmptyParkingSlots;
        parkingSlotList= new ArrayList<ParkingSlot>(Collections.nCopies(totalEmptyParkingSlots,emptyParkingSlotObject));
    }
    public VehiclePark(int totalParkingSlots,Boolean isFull) {
        if(!isFull)  new VehiclePark(totalParkingSlots);
        else {
            this.totalParkingSlots = totalParkingSlots;
            parkingSlotList= new ArrayList<ParkingSlot>(Collections.nCopies(totalParkingSlots,fullParkingSlotObject));
        }
    }



    public int getTotalParkingSlotsCount() {
        return totalParkingSlots;
    }

    public ParkingSlot getEmptyParkingSlot() {

        for(ParkingSlot slot :parkingSlotList){
            if(slot.getIsEmpty()) return slot;
        }
        return null;

    }

    public ParkingSlot markParked(ParkingSlot receivedEmptyParkingSlot, Person person) {
        for(ParkingSlot slot :parkingSlotList){
            if(Objects.equals(slot, receivedEmptyParkingSlot) && slot.getIsEmpty()) {
                slot.setIsEmpty(false);
                slot.setPerson(person);
                return slot;
            };
        }
        return null;
    }
}