package rental.class_problems;

public class VehicleRentalDemo {

    public static void main(String[] args) {

        VehicleRentalSystem system =
                new VehicleRentalSystem();

        Customer customer1 =
                new Customer("C1", "Customer 1");

        Customer customer2 =
                new Customer("C2", "Customer 2");

        Customer customer3 =
                new Customer("C3", "Customer 3");

        Vehicle sedan =
                new Sedan("Sedan A", 50);

        Vehicle suv =
                new SUV("SUV B", 80);

        Rental rental1 =
                system.rentVehicle(
                        customer1,
                        sedan,
                        3
                );

        system.rentVehicle(
                customer2,
                sedan,
                2
        );

        system.returnVehicle(rental1);

        system.rentVehicle(
                customer3,
                suv,
                5
        );
    }
}