package rental.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CampusVehicleDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNextLine()) {

            String line = sc.nextLine().trim();

            if (line.equalsIgnoreCase("EXIT")) {
                break;
            }

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equals("PASS")) {

                String type = parts[1];
                String passNumber = parts[2];
                String owner = parts[3];

                Vehicle vehicle = null;

                switch (type) {
                    case "Bike":
                        vehicle = new Bike(passNumber, owner);
                        break;

                    case "Car":
                        vehicle = new Car(passNumber, owner);
                        break;

                    case "EBike":
                        vehicle = new ElectricBike(passNumber, owner);
                        break;

                    case "ECar":
                        vehicle = new ElectricCar(passNumber, owner);
                        break;
                }

                if (vehicle != null) {
                    vehicles.put(passNumber, vehicle);

                    System.out.println(
                            passNumber + " (" + type + ") pass fee "
                                    + vehicle.calculatePassFee()
                    );
                }

            } else if (parts[0].equals("CHARGE")) {

                String passNumber = parts[1];

                Vehicle vehicle = vehicles.get(passNumber);

                if (vehicle == null) {
                    System.out.println("Vehicle not found");
                } else if (vehicle instanceof Chargeable) {
                    ((Chargeable) vehicle).bookChargingBay();
                } else {
                    System.out.println(
                            passNumber + " rejected: charging unsupported"
                    );
                }
            }
        }

        sc.close();
    }
}