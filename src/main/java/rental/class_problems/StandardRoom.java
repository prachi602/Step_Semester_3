package rental.class_problems;

public class StandardRoom extends Room {

    private double nightlyRate;

    public StandardRoom(String roomNumber, double nightlyRate) {
        super(roomNumber);

        if (nightlyRate <= 0) {
            throw new IllegalArgumentException(
                    "Nightly rate must be positive"
            );
        }

        this.nightlyRate = nightlyRate;
    }

    @Override
    public double calculatePrice(int nights) {
        if (nights <= 0) {
            throw new IllegalArgumentException(
                    "Number of nights must be positive"
            );
        }

        return nightlyRate * nights;
    }
}