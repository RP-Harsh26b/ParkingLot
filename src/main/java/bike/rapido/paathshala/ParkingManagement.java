package bike.rapido.paathshala;

import bike.rapido.paathshala.vehicle.Car;

import java.util.Scanner;

public class ParkingManagement {
	public static void main(String[] args)
	{
		System.out.println("Welcome to Parking Management System!!");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of vehicle : ");
		String vehicleNumber = scanner.nextLine();
		Car car = new Car(vehicleNumber);
		Person person = new Person(car);
		// TODO: 28/07/22 Uncomment the method when parkVehicle method is ready
//		int parkedLocation = person.parkVehicle(car);
//		System.out.format("Your vehicle %s is parked at %d",vehicleNumber,parkedLocation);


//		while (true) {
//			System.out.print("\n1.Park a Vehicle\n2.Exit!\n");
//			System.out.print("Enter the choice : ");
//			try {
//				Scanner choiceInput = new Scanner(System.in);
//				choice = choiceInput.nextInt();
//				switch (choice) {
//					case 1 -> {
//						Scanner scanner = new Scanner(System.in);
//						try {
//							System.out.println("Enter the vehicle number : ");
//							String vehicleNumber = scanner.nextLine();
//
//						} catch (Exception exception) {
//							System.err.println("\n====Invalid Input====");
//							System.err.println(exception);
//							System.err.println("Please enter a Integer Value!!\n====================");
//						}
//					}
//					case 2 -> {
//						System.out.println("Please visit us again!!");
//						System.exit(0);
//					}
//					default -> System.out.println("Enter a valid choice!!\nEither 1 or 2\n");
//				}
//			} catch (Exception exception) {
//				System.err.println("====Invalid Choice Type====");
//				System.err.println(exception);
//				System.err.println("Please enter a Integer Valued Choice!!");
//			}
//		}
	}
}
