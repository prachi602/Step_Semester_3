package rental.class_problems;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {

    private List<Rental> rentals;

    public VehicleRentalSystem() {
        rentals = new ArrayList<>();
    }

    public Rental rentVehicle(
            Customer customer,
            Vehicle vehicle,
            int durationDays) {

        if (!vehicle.isAvailable()) {
            System.out.println(
                    vehicle.getVehicleId()
                            + " is currently unavailable."
            );
            return null;
        }

        Rental rental =
                new Rental(customer, vehicle, durationDays);

        rentals.add(rental);
        vehicle.setAvailable(false);

        System.out.println(
                vehicle.getVehicleId()
                        + " rented successfully by "
                        + customer.getName()
        );

        System.out.println(
                "Rental charge: $"
                        + rental.getTotalCharge()
        );

        return rental;
    }

    public void returnVehicle(Rental rental) {

        if (rental == null) {
            System.out.println("Invalid rental.");
            return;
        }

        if (!rental.isActive()) {
            System.out.println(
                    "Rental has already been returned."
            );
            return;
        }

        Vehicle vehicle = rental.getVehicle();

        rental.closeRental();
        vehicle.setAvailable(true);

        System.out.println(
                vehicle.getVehicleId()
                        + " returned by "
                        + rental.getCustomer().getName()
        );
    }

    public boolean isVehicleAvailable(Vehicle vehicle) {
        return vehicle != null && vehicle.isAvailable();
    }
}