package bike.rapido.paathshala;

import bike.rapido.paathshala.notification.Owner;
import bike.rapido.paathshala.parking.ParkingSlot;
import bike.rapido.paathshala.parking.VehiclePark;
import bike.rapido.paathshala.vehicle.Car;

import java.util.Scanner;

public class ParkingManagement {
    Owner owner = new Owner();
    VehiclePark vehiclePark = new VehiclePark(10);

    public static void main(final String[] args) {
        final ParkingManagement parkingManagement = new ParkingManagement();
        System.out.println("\nWelcome to Parking Management System!!\n");
        System.out.print("Enter your name : ");

        final Scanner scanner = new Scanner(System.in);
        final String name = scanner.nextLine();

        System.out.print("Enter the number of vehicle : ");
        final String vehicleNumber = scanner.nextLine();

        final Car car = new Car(vehicleNumber);
        final Person person = new Person(car, name);

        try {
            final ParkingSlot parkedSlot = person.parkTheCar(parkingManagement.vehiclePark);
            System.out.format("Vehicle Parked!\nParking Slot Details : %s\n", parkedSlot);
        } catch (final Person.NoEmptyParkingSlotFoundException noEmptyParkingSlotFoundException) {
            System.out.println(
                    "At the moment all parking slots are full.\nWe are sorry for the unavailability in the service.");
        } finally {
            System.out.println("\nExiting from the system.");
            scanner.close();
        }
    }
}