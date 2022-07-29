package bike.rapido.paathshala;

import bike.rapido.paathshala.parking.ParkingSlot;
import bike.rapido.paathshala.parking.VehiclePark;
import bike.rapido.paathshala.vehicle.Car;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class PersonTest {

	public final Car car = new Car("DL5CQ 0258");
	public final int totalParkingSlots = 10;
	public Person person;
	public VehiclePark testEmptyPark = new VehiclePark(totalParkingSlots);
	public VehiclePark testFullVehiclePark = new VehiclePark(totalParkingSlots, true);


	@Before
	public void setUp() {
		person = new Person(car, "Harshit");
	}

	@Test
	public void returnObjectOfCar() {
		Car receivedCarObject = person.getCar();

		assertThat(car, is(receivedCarObject));
	}

	@Test
	public void shouldReturnDetailedStringWhenCalledToString() {
		String returnedString = person.toString();

		assertThat(returnedString, is("Person{car=Car{carNumber='DL5CQ 0258'}}"));
	}

	// TODO: 28/07/22 uncomment the test when the parkVehicle is ready
	@Test
	public void parkVehicleShouldReturnBooleanWhenEmptySlotIsPresent() throws Person.NoEmptyParkingSlotFoundException {

		ParkingSlot receivedOutput = person.parkVehicle(testEmptyPark);
		System.out.println(receivedOutput);

		assertNotNull(receivedOutput);
	}

	@Test(expected = Person.NoEmptyParkingSlotFoundException.class)
	public void parkVehicleShouldThrowExceptionWhenEmptySlotIsNotPresent() throws Person.NoEmptyParkingSlotFoundException {
		ParkingSlot receivedOutput = person.parkVehicle(testFullVehiclePark);
		System.out.println(receivedOutput);
	}


}
