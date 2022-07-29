package bike.rapido.paathshala.vehicle;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarTest {
	public static final String CAR_NUMBER = "DL5CQ 1234";
	private Car car;

	@Before
	public void setup() {
		car = new Car(CAR_NUMBER);
	}

	@Test
	public void shouldReturnDetailsOfCar() {
		String receivedCarDetails = car.toString();

		assertThat(receivedCarDetails, is("Car{" +
			"carNumber='" + CAR_NUMBER + '\'' +
			'}'));
	}
}
