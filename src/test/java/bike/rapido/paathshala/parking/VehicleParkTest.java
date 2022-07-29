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

	public Person samplePerson = new Person(sampleCar, "Harshit");

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
		ParkingSlot receivedFullParkingSlot = emptyVehiclePark.markParked(receivedEmptyParkingSlot, samplePerson.getCar());

		assertThat(receivedFullParkingSlot.getIsEmpty(), is(false));
		assertNotNull(receivedFullParkingSlot.getCar());
	}

	// TODO: 29/07/22 should change to shouldThrowException when provided slot is not present in car park
	@Test
	public void shouldReturnNullWhenProvidedParkingSlotIsNotFound() {
		ParkingSlot invalidParkingSlot = new ParkingSlot(200, sampleCar);
		ParkingSlot receivedFullParkingSlot = emptyVehiclePark.markParked(invalidParkingSlot, samplePerson.getCar());

		assertNull(receivedFullParkingSlot);
	}
}
