package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.notification.ParkingLotObserver;
import bike.rapido.paathshala.vehicle.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehiclePark {

    private final Integer totalParkingSlots;
    private final List<ParkingLotObserver> observerList = new ArrayList<>();
    private ArrayList<ParkingSlot> parkingSlotList = new ArrayList<>();
    private Integer parkedCarCount = 0;


    public VehiclePark(final int totalEmptyParkingSlots) {
        this.totalParkingSlots = totalEmptyParkingSlots;
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
        for (ParkingLotObserver observer : observerList) {
            System.out.println(observer.notifyFull());
        }
    }

    public void register(ParkingLotObserver observerEntity) {
        observerList.add(observerEntity);
    }

    public void unRegister(ParkingLotObserver observerEntity) {
        observerList.remove(observerEntity);
    }
}