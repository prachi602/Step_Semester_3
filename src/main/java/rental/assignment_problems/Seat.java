package rental.assignment_problems;

public abstract class Seat {

    private String seatNumber;

    public Seat(String seatNumber) {
        if (seatNumber == null || seatNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Seat number cannot be blank"
            );
        }

        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public abstract double getPrice();
}