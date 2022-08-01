package bike.rapido.paathshala.parking;

import bike.rapido.paathshala.vehicle.Car;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ParkingSlotTest {
	private final Car sampleCar = new Car("DL5CQ 0258");
	private ParkingSlot parkingSlot;

	@Before
	public void setUp() {
		parkingSlot = new ParkingSlot(sampleCar);
	}

	@Test
	public void shouldReturnId() {
		final int returnedId = parkingSlot.getId();

		assertThat(returnedId, CoreMatchers.instanceOf(Integer.class));
	}

	@Test
	public void shouldReturnIsEmpty() {
		final boolean returnedIsEmpty = parkingSlot.getIsEmpty();

		assertThat(returnedIsEmpty, instanceOf(Boolean.class));
	}

	@Test
	public void shouldReturnCarIfNotEmpty() {
		final Car returnedCar = parkingSlot.getCar();

		assertThat(returnedCar, is(sampleCar));
	}

	@Test
	public void shouldReturnNullIfEmpty() {
		final ParkingSlot emptyParkingSlot = new ParkingSlot();

		final Car returnedCar = emptyParkingSlot.getCar();

		assertNull(returnedCar);
	}

	@Test
	public void shouldReturnDetailedStringOfParkingSlot() {

		final ParkingSlot parkingSlot = new ParkingSlot(100, sampleCar);

		final String receivedString = parkingSlot.toString();

		assertTrue(receivedString.contains("carNumber='DL5CQ 0258'"));
		assertTrue(receivedString.contains("id=100"));
		assertTrue(receivedString.contains("isEmpty=false"));
	}
}
