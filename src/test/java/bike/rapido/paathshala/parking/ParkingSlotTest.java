package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.Person;
import bike.rapido.paathshala.vehicle.Car;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

public class ParkingSlotTest {
	private final ParkingSlot emptyParkingSlot = new ParkingSlot();

	private final Car sampleCar = new Car("DL5CQ 0258");
	private Person samplePerson;
	private ParkingSlot nonEmptyParkingSlot;

	@Before
	public void setUp() {
		samplePerson = new Person(sampleCar, "Harshit");
		nonEmptyParkingSlot = new ParkingSlot(sampleCar);
	}

	@Test
	public void shouldReturnId() {
		int returnedId = nonEmptyParkingSlot.getId();

		assertThat(returnedId, CoreMatchers.instanceOf(Integer.class));
	}

	@Test
	public void shouldReturnIsEmpty() {
		boolean returnedIsEmpty = nonEmptyParkingSlot.getIsEmpty();

		assertThat(returnedIsEmpty, instanceOf(Boolean.class));
	}

	@Test
	public void shouldReturnCarIfNotEmpty() {
		Car returnedCar = nonEmptyParkingSlot.getCar();

		assertThat(returnedCar, is(sampleCar));
	}

	@Test
	public void shouldReturnNullIfEmpty() {
		Car returnedCar = emptyParkingSlot.getCar();

		assertNull(returnedCar);
	}

	@Test
	public void shouldReturnDetailedStringOfParkingSlot() {

		ParkingSlot testFullParkingSlot = new ParkingSlot(100, sampleCar);

		String receivedString = testFullParkingSlot.toString();
		String expectedString = "ParkingSlot{id=100, isEmpty=false, car=Car{carNumber='DL5CQ 0258'}}";

		assertThat(receivedString, is(expectedString));
	}
}
