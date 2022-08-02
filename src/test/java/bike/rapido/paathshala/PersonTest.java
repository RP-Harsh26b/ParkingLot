package bike.rapido.paathshala;

import bike.rapido.paathshala.notification.Owner;
import bike.rapido.paathshala.parking.ParkingSlot;
import bike.rapido.paathshala.parking.VehiclePark;
import bike.rapido.paathshala.vehicle.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    public final Car car = new Car("DL5CQ 0258");
    public final int totalParkingSlots = 10;
    public Person person;
    public VehiclePark vehicleParkArea;
    public Owner owner;

    public void fillAllParkingSlots() {
        final String tempNumber = "DL5CQ 025";
        final int index = 0;
        for (final ParkingSlot parkingSlot : vehicleParkArea.getParkingSlotList()) {
            parkingSlot.setCar(new Car(tempNumber + index));
        }
    }

    @Before
    public void setUp() {
        person = new Person(car, "Harshit");
        owner = new Owner();
        vehicleParkArea = new VehiclePark(totalParkingSlots, owner);
    }

    @Test
    public void shouldReturnDetailsOfThePerson() {
        person = new Person(car, "Harshit");

        final String returnedString = person.getDetails();

        assertTrue(returnedString.contains("carNumber='DL5CQ 0258'"));
        assertTrue(returnedString.contains("name='Harshit'"));
    }

    @Test
    public void shouldReturnParkingSlotWhenEmptySlotIsPresent() throws Person.NoEmptyParkingSlotFoundException {

        final ParkingSlot receivedOutput = person.parkTheCar(vehicleParkArea);

        assertNotNull(receivedOutput);
    }

    @Test(expected = Person.NoEmptyParkingSlotFoundException.class)
    public void parkVehicleShouldThrowExceptionWhenEmptySlotIsNotPresent()
            throws Person.NoEmptyParkingSlotFoundException {
        fillAllParkingSlots();
        //todo catch exception thrown by park() in try block
        person.parkTheCar(vehicleParkArea);
    }

    @Test
    public void shouldEmptySlotWhenCarIsUnParked() throws Person.NoEmptyParkingSlotFoundException {

        person.parkTheCar(vehicleParkArea);
        final ParkingSlot receivedParkingSlot = person.unParkTheCar(vehicleParkArea);

        assertTrue(receivedParkingSlot.getIsEmpty());
        assertNull(receivedParkingSlot.getCar());
    }
}