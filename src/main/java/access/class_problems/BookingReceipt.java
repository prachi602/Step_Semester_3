package access.class_problems;

public class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {

        if (bookingId == null || seatNumbers == null) {
            throw new IllegalArgumentException(
                    "Booking ID and seat numbers cannot be null"
            );
        }

        this.bookingId = bookingId;

        // Defensive copy IN
        this.seatNumbers = seatNumbers.clone();
    }

    public String[] getSeatNumbers() {

        // Defensive copy OUT
        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {

        if (index < 0 || index >= seatNumbers.length) {
            throw new IndexOutOfBoundsException(
                    "Invalid seat index"
            );
        }

        String[] updatedSeats = seatNumbers.clone();
        updatedSeats[index] = newSeat;

        return new BookingReceipt(bookingId, updatedSeats);
    }

    public String getBookingId() {
        return bookingId;
    }

    public static void main(String[] args) {

        BookingReceipt b =
                new BookingReceipt(
                        "CH-1001",
                        new String[]{"A1", "A2"}
                );

        // Test defensive copy OUT
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";

        System.out.println(
                "Original first seat: "
                        + b.getSeatNumbers()[0]
        );

        // Test wither method
        BookingReceipt updated =
                b.withUpdatedSeat(1, "A3");

        System.out.println(
                "Original receipt: "
                        + String.join(", ", b.getSeatNumbers())
        );

        System.out.println(
                "Updated receipt: "
                        + String.join(", ", updated.getSeatNumbers())
        );
    }
}