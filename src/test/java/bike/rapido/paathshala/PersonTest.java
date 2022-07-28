package bike.rapido.paathshala;

import bike.rapido.paathshala.vehicle.Car;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonTest {

	private Person person;
	private final Car car = new Car("DL5CQ 0258");
	@Before
	public void setup()
	{
		person = new Person(car);
	}

	@Test
	public void returnObjectOfCar()
	{
		Car receivedCarObject = person.getCar();

		assertThat(car,is(receivedCarObject));
	}

	@Test
	public void parkVehicleShouldReturnBoolean() {

		Boolean expectedOutput = true;
		Boolean receivedOutput = person.parkVehicle();

		assertThat(expectedOutput,is(receivedOutput));
	}
}
