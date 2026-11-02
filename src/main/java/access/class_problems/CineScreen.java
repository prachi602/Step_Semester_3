package access.class_problems;

public class CineScreen {

    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {

        if (seatsTotal <= 0) {
            throw new IllegalArgumentException(
                    "Total seats must be greater than 0"
            );
        }

        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {

        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    public void cancelBooking() {

        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static void main(String[] args) {

        try {
            CineScreen invalidScreen = new CineScreen(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid screen rejected.");
        }

        CineScreen screen = new CineScreen(2);

        screen.bookSeat();
        screen.bookSeat();
        screen.bookSeat();

        System.out.println(
                "Available after 3 bookings: "
                        + screen.getSeatsAvailable()
        );

        screen.cancelBooking();
        screen.cancelBooking();
        screen.cancelBooking();

        System.out.println(
                "Available after 3 cancellations: "
                        + screen.getSeatsAvailable()
        );
    }
}