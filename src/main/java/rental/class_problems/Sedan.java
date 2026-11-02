package rental.class_problems;

public class Sedan extends Vehicle {

    private double dailyRate;

    public Sedan(String vehicleId, double dailyRate) {
        super(vehicleId);

        if (dailyRate <= 0) {
            throw new IllegalArgumentException(
                    "Daily rate must be positive"
            );
        }

        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCharge(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Rental duration must be positive"
            );
        }

        return dailyRate * days;
    }
}