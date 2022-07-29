package bike.rapido.paathshala;

import bike.rapido.paathshala.parking.ParkingSlot;
import bike.rapido.paathshala.parking.VehiclePark;
import bike.rapido.paathshala.vehicle.Car;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PersonTest {

	public final Car car = new Car("DL5CQ 0258");
	public final int totalParkingSlots = 10;
	public Person person;
	public VehiclePark testVehiclePark = new VehiclePark(totalParkingSlots);
	public VehiclePark testFullVehiclePark = new VehiclePark(totalParkingSlots);

	@Before
	public void setUp() {
		person = new Person(car, "Harshit");
		final String tempNumber = "DL5CQ 025";
		final int index = 0;
		for (final ParkingSlot parkingSlot : testFullVehiclePark.getParkingSlotList()) {
			parkingSlot.setCar(new Car(tempNumber + index));
		}
	}

	@Test
	public void returnObjectOfCar() {
		final Car receivedCarObject = person.getCar();

		assertThat(car, is(receivedCarObject));
	}

	@Test
	public void shouldReturnDetailedStringWhenCalledToString() {
		final String returnedString = person.toString();

		assertThat(returnedString, is("Person{car=Car{carNumber='DL5CQ 0258'}, name='Harshit'}"));
	}

	// TODO: 28/07/22 uncomment the test when the parkVehicle is ready
	@Test
	public void parkVehicleShouldReturnBooleanWhenEmptySlotIsPresent() throws Person.NoEmptyParkingSlotFoundException {

		final ParkingSlot receivedOutput = person.park(testVehiclePark);

		assertNotNull(receivedOutput);
	}

	@Test(expected = Person.NoEmptyParkingSlotFoundException.class)
	public void parkVehicleShouldThrowExceptionWhenEmptySlotIsNotPresent()
		throws Person.NoEmptyParkingSlotFoundException {
		System.out.println(testFullVehiclePark);
		final ParkingSlot receivedOutput = person.park(testFullVehiclePark);
	}

	@Test
	public void shouldChangeSlotToEmptyWhenUnparkCalled() throws Person.NoEmptyParkingSlotFoundException {

		person.park(testVehiclePark);
		final ParkingSlot receivedParkingSlot = person.unpark(person, testVehiclePark);
		assertThat(receivedParkingSlot.getIsEmpty(), is(Boolean.TRUE));
		assertNull(receivedParkingSlot.getCar());
	}
}
