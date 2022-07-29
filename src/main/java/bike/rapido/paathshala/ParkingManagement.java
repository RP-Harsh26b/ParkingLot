package bike.rapido.paathshala;

import bike.rapido.paathshala.parking.ParkingSlot;
import bike.rapido.paathshala.parking.VehiclePark;
import bike.rapido.paathshala.vehicle.Car;

import java.util.Scanner;

public class ParkingManagement {

	VehiclePark vehiclePark = new VehiclePark(10);

	public static void main(String[] args) {
		ParkingManagement parkingManagement = new ParkingManagement();
		System.out.println("\nWelcome to Parking Management System!!\n");
		System.out.println("Enter your name.");

		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();

		System.out.print("Enter the number of vehicle : ");
		String vehicleNumber = scanner.nextLine();
		
		Car car = new Car(vehicleNumber);
		Person person = new Person(car, name);

		// TODO: 28/07/22 Uncomment the method when parkVehicle method is ready

		try {
			ParkingSlot parkedSlot = person.parkVehicle(parkingManagement.vehiclePark);
			System.out.format("Vehicle Parked!\nParking Slot Details:" + parkedSlot);
		} catch (Person.NoEmptyParkingSlotFoundException noEmptyParkingSlotFoundException) {
			System.out.println("At the moment all parking slots are full.\nWe are sorry for the unavailability in the service.");
		} finally {
			System.out.println("Exiting from the system.");
			scanner.close();
		}
	}
}
