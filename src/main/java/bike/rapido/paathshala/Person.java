package bike.rapido.paathshala;

import bike.rapido.paathshala.parking.ParkingSlot;
import bike.rapido.paathshala.parking.VehiclePark;
import bike.rapido.paathshala.vehicle.Car;

public class Person {

    private final Car car;
    private final String name;

    public Person(Car car, String name) {
        this.car = car;
        this.name = name;
    }

    public Car getCar() {
        return this.car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                ", name='" + name + '\'' +
                '}';
    }

    public ParkingSlot park(VehiclePark vehiclePark) throws NoEmptyParkingSlotFoundException {

        ParkingSlot parkingSlot = vehiclePark.getEmptyParkingSlot();
        ParkingSlot filledParkingSlot;
        if (parkingSlot != null) {
            filledParkingSlot = vehiclePark.markParked(parkingSlot, this.getCar());
        } else {
            throw new NoEmptyParkingSlotFoundException("No Empty Parking Slot Found");
        }
        return filledParkingSlot;

    }

    public ParkingSlot unpark(Person person, VehiclePark vehiclePark) throws NoEmptyParkingSlotFoundException {
        System.out.println(vehiclePark);
        ParkingSlot receivedParkedSlot = vehiclePark.getParkingSlotWithVehicle(person.getCar());
        ParkingSlot receivedEmptyParkingSlot;

        System.out.println(receivedParkedSlot);
        if (receivedParkedSlot == null) {
            throw new NoEmptyParkingSlotFoundException("Could not find the car in VehiclePark");
        } else {
            receivedEmptyParkingSlot = vehiclePark.markUnParked(receivedParkedSlot);
        }
        return receivedEmptyParkingSlot;
    }

    public static class NoEmptyParkingSlotFoundException extends Exception {
        public NoEmptyParkingSlotFoundException(String message) {
            super(message);
        }
    }

    public static class NoParkingSlotWithGivenCarFoundException extends Exception {
        public NoParkingSlotWithGivenCarFoundException(String message) {
            super(message);
        }
    }


}