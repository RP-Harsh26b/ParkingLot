package bike.rapido.paathshala.parking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingSlotTest {

	public static final int TOTAL_PARKING_SLOTS = 100;
	private ParkingSlot parkingSlot;

	@Before
	public void setUp() throws Exception {
		parkingSlot = new ParkingSlot(TOTAL_PARKING_SLOTS);
	}

	@Test
	public void shouldReturnNumberOfEmptySlotsInParkingArea() {
		int receivedOutput = parkingSlot.getEmptyParkingSlotsCount();

		assertThat(receivedOutput,is(TOTAL_PARKING_SLOTS));

	}
}
