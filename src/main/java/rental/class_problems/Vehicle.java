package rental.class_problems;

public abstract class Vehicle {

    private String vehicleId;
    private boolean available;

    public Vehicle(String vehicleId) {
        if (vehicleId == null || vehicleId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Vehicle ID cannot be blank"
            );
        }

        this.vehicleId = vehicleId;
        this.available = true;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRentalCharge(int days);
}