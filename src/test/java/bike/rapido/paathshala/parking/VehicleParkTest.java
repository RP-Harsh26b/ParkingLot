package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.vehicle.Car;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class VehicleParkTest {
    public static final int TOTAL_PARKING_SLOTS = 10;
    public VehiclePark vehicleParkArea;

    Car sampleCar = new Car("DL5CQ 0258");

    public void fillAllParkingSlots() {
        final String tempNumber = "DL5CQ 025";
        final int index = 0;
        for (final ParkingSlot parkingSlot : vehicleParkArea.getParkingSlotList()) {
            parkingSlot.setCar(new Car(tempNumber + index));
        }
    }

    @Before
    public void setUp() {
        vehicleParkArea = new VehiclePark(TOTAL_PARKING_SLOTS);
    }

    @Test
    public void shouldReturnTotalNumberOfSlotsInParkingArea() {
        final int receivedOutput = vehicleParkArea.getTotalParkingSlotsCount();

        assertThat(receivedOutput, is(TOTAL_PARKING_SLOTS));
    }

    @Test
    public void shouldReturnEmptyParkingSlotWhenExist() {
        final ParkingSlot receivedParkingSlot = vehicleParkArea.getEmptyParkingSlot();

        assertNotNull(receivedParkingSlot);
        assertTrue(receivedParkingSlot.getIsEmpty());
    }

    @Test
    public void shouldReturnNullWhenEmptyParkingSlotDoesNotExist() {
        fillAllParkingSlots();
        final ParkingSlot receivedParkingSlot = vehicleParkArea.getEmptyParkingSlot();

        assertNull(receivedParkingSlot);
    }

    @Test
    public void shouldReturnAFilledParkingSlotWhenMarkParked() {
        final ParkingSlot receivedEmptyParkingSlot = vehicleParkArea.getEmptyParkingSlot();
        final ParkingSlot receivedFilledParkingSlot = vehicleParkArea.markParked(receivedEmptyParkingSlot, sampleCar);

        assertFalse(receivedFilledParkingSlot.getIsEmpty());
        assertNotNull(receivedFilledParkingSlot.getCar());
    }

    @Test
    public void shouldReturnNullWhenProvidedParkingSlotIsNotFound() {
        final ParkingSlot invalidParkingSlot = new ParkingSlot(200, sampleCar);

        final ParkingSlot receivedFullParkingSlot = vehicleParkArea.markParked(invalidParkingSlot, sampleCar);

        assertNull(receivedFullParkingSlot);
    }

    @Test
    public void shouldReturnEmptySlotWhenCarUnParked() {
        final ParkingSlot emptyParkingSlot = vehicleParkArea.getEmptyParkingSlot();
        vehicleParkArea.markParked(emptyParkingSlot, sampleCar);

        final ParkingSlot parkedParkingSlot = vehicleParkArea.getParkingSlotWithVehicle(sampleCar);
        final ParkingSlot returnedParkingSlot = vehicleParkArea.markUnParked(parkedParkingSlot);

        assertTrue(returnedParkingSlot.getIsEmpty());
    }

    @Test
    public void shouldReturnTrueWhenAllParkingSlotsAreFull() {
        fillAllParkingSlots();

        Boolean isFullIndicator = vehicleParkArea.getIsFull();

        assertTrue(isFullIndicator);
    }

    @Test
    public void shouldReturnFalseWhenAllParkingSlotsAreNotFull() {
        Boolean isFullIndicator = vehicleParkArea.getIsFull();

        assertFalse(isFullIndicator);
    }

}