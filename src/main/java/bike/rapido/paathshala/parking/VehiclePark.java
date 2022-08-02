package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.notification.Owner;
import bike.rapido.paathshala.notification.SecurityPersonal;
import bike.rapido.paathshala.vehicle.Car;

import java.util.ArrayList;
import java.util.Objects;

public class VehiclePark {

    private final Integer totalParkingSlots;
    private final Owner owner;

    private final SecurityPersonal securityPersonal;
    private ArrayList<ParkingSlot> parkingSlotList = new ArrayList<>();
    private Integer parkedCarCount = 0;


    public VehiclePark(final int totalEmptyParkingSlots, Owner owner) {
        this(totalEmptyParkingSlots, owner, new SecurityPersonal());
    }

    public VehiclePark(final int totalEmptyParkingSlots, Owner owner, SecurityPersonal securityPersonal) {
        this.totalParkingSlots = totalEmptyParkingSlots;
        this.owner = owner;
        this.securityPersonal = securityPersonal;
        this.parkingSlotList = new ArrayList<>();
        for (int index = 0; index < totalEmptyParkingSlots; index++) {
            parkingSlotList.add(new ParkingSlot());
        }

    }

    public int getTotalParkingSlotsCount() {
        return totalParkingSlots;
    }

    public ParkingSlot getEmptyParkingSlot() {

        for (ParkingSlot slot : parkingSlotList) {
            if (slot.getIsEmpty()) {
                return slot;
            }
        }
        return null;
    }

    public Integer getParkedCarCount() {
        return parkedCarCount;
    }

    public void setParkedCarCount(Integer parkedCarCount) {
        this.parkedCarCount = parkedCarCount;
        if (Objects.equals(parkedCarCount, totalParkingSlots)) {
            notifyFull();
        }
    }

    public ArrayList<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public ParkingSlot getParkingSlotWithVehicle(final Car car) {

        for (final ParkingSlot slot : parkingSlotList) {
            if ((slot.getCar() != null) && (slot.getCar().equals(car))) {
                return slot;
            }
        }
        return null;

    }

    public ParkingSlot markParked(ParkingSlot emptyParkingSlot, final Car car) {
        for (ParkingSlot slot : parkingSlotList) {
            if (slot.getId().equals(emptyParkingSlot.getId()) && slot.getIsEmpty()) {
                slot.setCar(car);
                setParkedCarCount(getParkedCarCount() + 1);
                return slot;
            }
        }
        return null;
    }

    public ParkingSlot markUnParked(final ParkingSlot fullParkingSlot) {
        for (final ParkingSlot slot : parkingSlotList) {
            if (Objects.equals(slot, fullParkingSlot)) {
                slot.setCar(null);
                setParkedCarCount(getParkedCarCount() - 1);
                return slot;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "VehiclePark{" +
                " totalParkingSlots=" + totalParkingSlots +
                ", parkingSlotList=" + parkingSlotList +
                '}';
    }

    public Boolean getIsFull() {
        return (Objects.equals(parkedCarCount, totalParkingSlots));
    }


    public void notifyFull() {
        System.out.println(owner.notifyFull());
        System.out.println(securityPersonal.notifyFull());
    }
}