package bike.rapido.paathshala.parking;

import org.junit.Before;
import org.junit.Test;

public class VehicleParkTest {
    public static final int TOTAL_PARKING_SLOTS = 100;
    private VehiclePark vehiclePark;

    @Before
    public void setUp() {
        vehiclePark = new VehiclePark(TOTAL_PARKING_SLOTS);
    }

//    @Test
//    public void shouldReturnNumberOfEmptySlotsInParkingArea() {
//        int receivedOutput = vehiclePark.getEmptyParkingSlotsCount();
//
//        assertThat(receivedOutput,is(TOTAL_PARKING_SLOTS));
//
//    }

}
