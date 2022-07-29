package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.Person;
import bike.rapido.paathshala.vehicle.Car;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class VehicleParkTest {
    public static final int TOTAL_PARKING_SLOTS = 100;
    public VehiclePark emptyVehiclePark, fullVehiclePark;
    Car sampleCar = new Car("DL5CQ 0258");

    @Before
    public void setUp() {
        emptyVehiclePark = new VehiclePark(TOTAL_PARKING_SLOTS);
        fullVehiclePark = new VehiclePark(TOTAL_PARKING_SLOTS, true);
    }

    @Test
    public void shouldReturnTotalNumberOfSlotsInParkingArea() {
        int receivedOutput = emptyVehiclePark.getTotalParkingSlotsCount();

        assertThat(receivedOutput, is(TOTAL_PARKING_SLOTS));

    }

    @Test
    public void shouldReturnEmptyParkingSlotWhenGetEmptyParkingSlotMethodCalledAndEmptyParkingSlotExist() {
        ParkingSlot receivedParkingSlot = emptyVehiclePark.getEmptyParkingSlot();

        assertThat(receivedParkingSlot.getIsEmpty(), is(true));
    }

    @Test
    public void shouldReturnNullWhenEmptyParkingSlotDoesNotExist() {
        ParkingSlot receivedParkingSlot = fullVehiclePark.getEmptyParkingSlot();

        assertNull(receivedParkingSlot);
    }

    @Test
    public void shouldReturnFullParkingSlotWhenMarkParkedIsCalled() {
        ParkingSlot receivedEmptyParkingSlot = emptyVehiclePark.getEmptyParkingSlot();
        ParkingSlot receivedFullParkingSlot = emptyVehiclePark.markParked(receivedEmptyParkingSlot, sampleCar);

        assertThat(receivedFullParkingSlot.getIsEmpty(), is(false));
        assertNotNull(receivedFullParkingSlot.getCar());
    }

    // TODO: 29/07/22 should change to shouldThrowException when provided slot is not present in car park
    @Test
    public void shouldReturnNullWhenProvidedParkingSlotIsNotFound() {
        ParkingSlot invalidParkingSlot = new ParkingSlot(200, sampleCar);
        ParkingSlot receivedFullParkingSlot = emptyVehiclePark.markParked(invalidParkingSlot, sampleCar);

        assertNull(receivedFullParkingSlot);
    }

    @Test
    public void shouldReturnEmptySlotWhenUnparkMethodIsCalledAndEnteredCarExist() throws Person.NoEmptyParkingSlotFoundException {
        ParkingSlot emptyParkingSlot = emptyVehiclePark.getEmptyParkingSlot();
        emptyVehiclePark.markParked(emptyParkingSlot, sampleCar);
        ParkingSlot parkedParkingSlot = emptyVehiclePark.getParkingSlotWithVehicle(sampleCar);
        ParkingSlot returnedParkingSlot = emptyVehiclePark.markUnParked(parkedParkingSlot);

        assertThat(returnedParkingSlot.getIsEmpty(), is(true));
    }
}