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
	private final ParkingSlot emptyParkingSlot = new ParkingSlot(true, null);
	private Person samplePerson;
	private ParkingSlot nonEmptyParkingSlot;

	@Before
	public void setUp() {
		samplePerson = new Person(new Car("DL5CQ 0258"), "Harshit");
		nonEmptyParkingSlot = new ParkingSlot(false, samplePerson);
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
	public void shouldReturnPersonIfNotEmpty() {
		Person returnedPerson = nonEmptyParkingSlot.getPerson();

		assertThat(returnedPerson, is(samplePerson));
	}

	@Test
	public void shouldReturnNullIfEmpty() {
		Person returnedPerson = emptyParkingSlot.getPerson();

		assertNull(returnedPerson);
	}

	@Test
	public void shouldReturnDetailedStringOfParkingSlot() {
		String receivedString = nonEmptyParkingSlot.toString();
		String expectedString = "ParkingSlot{id=6, isEmpty=false, person=Person{car=Car{carNumber='DL5CQ 0258'}}}";

		assertThat(receivedString, is(expectedString));
	}
}
