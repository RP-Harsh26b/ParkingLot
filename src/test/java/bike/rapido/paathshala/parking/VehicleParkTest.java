package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.notification.Owner;
import bike.rapido.paathshala.notification.SecurityPersonal;
import bike.rapido.paathshala.vehicle.Car;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class VehicleParkTest {
    public static int TOTAL_PARKING_SLOTS = 5;
    public VehiclePark vehicleParkArea;

    Car sampleCar = new Car("DL5CQ 0258");

    public void fillAllParkingSlots() {
        final String tempNumber = "DL5CQ 025";
        for (int index = 0; index < TOTAL_PARKING_SLOTS; index++) {
            ParkingSlot emptyParkingSlot = vehicleParkArea.getEmptyParkingSlot();
            if (emptyParkingSlot != null) {
                vehicleParkArea.markParked(emptyParkingSlot, sampleCar);
            } else {
                System.out.println("getting null");
            }
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

        ParkingSlot emptySlot;
        while ((emptySlot = vehicleParkArea.getEmptyParkingSlot()) != null) {
            vehicleParkArea.markParked(emptySlot, sampleCar);

        }

        Boolean isFullIndicator = vehicleParkArea.getIsFull();

        assertTrue(isFullIndicator);
    }

    @Test
    public void shouldReturnFalseWhenAllParkingSlotsAreNotFull() {
        Boolean isFullIndicator = vehicleParkArea.getIsFull();

        assertFalse(isFullIndicator);
    }

    //TODO add notify method test

    @Test
    public void shouldNotifyWhenVehicleParkGetsFull() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream outError = new ByteArrayOutputStream();
        PrintStream sysError = System.err, sysOut = System.out;
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(outError));
        String expectedSubString1 = "Owner showed vehicle park full sign.";
        String expectedSubString2 = "Security Personal informed the team about parking lot getting full.";
        Owner owner = new Owner();
        SecurityPersonal securityPersonal = new SecurityPersonal();
        owner.register(vehicleParkArea);
        securityPersonal.register(vehicleParkArea);
        fillAllParkingSlots();
        String printedString = outContent.toString();

        System.out.println(printedString);

        assertTrue(printedString.contains(expectedSubString1));
        assertTrue(printedString.contains(expectedSubString2));


        System.setOut(sysOut);
        System.setErr(sysError);

    }

    @Test
    public void shouldNotifyWhenVehicleParkChangesFromFullToNotFull() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream outError = new ByteArrayOutputStream();
        PrintStream sysError = System.err, sysOut = System.out;
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(outError));
        String expectedSubString1 = "Owner removed the vehicle park full sign.";
        String expectedSubString2 = "Security Personal informed the team about parking lot changing to not full.";


        Owner owner = new Owner();
        SecurityPersonal securityPersonal = new SecurityPersonal();
        owner.register(vehicleParkArea);
        securityPersonal.register(vehicleParkArea);
        fillAllParkingSlots();
        ParkingSlot parkingSlot = vehicleParkArea.getParkingSlotWithVehicle(sampleCar);
        vehicleParkArea.markUnParked(parkingSlot);

        String printedString = outContent.toString();

        System.out.println(printedString);

        assertTrue(printedString.contains(expectedSubString1));
        assertTrue(printedString.contains(expectedSubString2));


        System.setOut(sysOut);
        System.setErr(sysError);


    }
}