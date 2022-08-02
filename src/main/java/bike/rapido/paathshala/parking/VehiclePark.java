package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.vehicle.Car;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;

public class VehiclePark extends Observable {

    private final Integer totalParkingSlots;
    private final ArrayList<ParkingSlot> parkingSlotList;
    private Integer parkedCarCount = 0;

    private Boolean isFull;


    public VehiclePark(final int totalEmptyParkingSlots) {
        this.totalParkingSlots = totalEmptyParkingSlots;
        this.parkingSlotList = new ArrayList<>();
        for (int index = 0; index < totalEmptyParkingSlots; index++) {
            parkingSlotList.add(new ParkingSlot());
        }
        this.isFull = getIsFull();
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
            setFull(true);
        } else if (this.parkedCarCount == (totalParkingSlots - 1)) {
            setFull(false);
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
            if (slot.getId().equals(fullParkingSlot.getId()) && !slot.getIsEmpty()) {
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


    public void setFull(Boolean isFull) {
        this.isFull = isFull;
        setChanged();
        notifyObservers(isFull);
    }

}