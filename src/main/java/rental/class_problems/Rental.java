package rental.class_problems;

public class Rental {

    private Customer customer;
    private Vehicle vehicle;
    private int durationDays;
    private double totalCharge;
    private boolean active;

    public Rental(
            Customer customer,
            Vehicle vehicle,
            int durationDays) {

        if (customer == null) {
            throw new IllegalArgumentException(
                    "Customer cannot be null"
            );
        }

        if (vehicle == null) {
            throw new IllegalArgumentException(
                    "Vehicle cannot be null"
            );
        }

        if (durationDays <= 0) {
            throw new IllegalArgumentException(
                    "Duration must be positive"
            );
        }

        this.customer = customer;
        this.vehicle = vehicle;
        this.durationDays = durationDays;
        this.totalCharge =
                vehicle.calculateRentalCharge(durationDays);
        this.active = true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public boolean isActive() {
        return active;
    }

    public void closeRental() {
        active = false;
    }
}