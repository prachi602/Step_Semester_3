package rental.assignment_problems;

import java.util.List;

public class TicketBookingSystem {

    public Booking createBooking(
            Customer customer,
            Show show,
            List<Seat> seats) {

        if (customer == null || show == null || seats == null) {
            throw new IllegalArgumentException(
                    "Customer, show and seats are required"
            );
        }

        if (seats.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one seat is required"
            );
        }

        if (seats.size() > 6) {
            System.out.println(
                    "Cannot book more than 6 seats."
            );
            return null;
        }

        // Check every seat before reserving any seat
        for (Seat seat : seats) {

            if (!show.isSeatAvailable(seat)) {
                System.out.println(
                        "Seat "
                                + seat.getSeatNumber()
                                + " is already booked for this show."
                );
                return null;
            }
        }

        // Reserve all seats
        for (Seat seat : seats) {
            show.reserveSeat(seat);
        }

        Booking booking =
                new Booking(
                        customer,
                        show,
                        seats
                );

        System.out.println(
                "Booking confirmed for "
                        + customer.getName()
                        + ": "
                        + getSeatNumbers(seats)
        );

        System.out.printf(
                "Total: ₹%.2f%n",
                booking.calculateTotal()
        );

        return booking;
    }

    private String getSeatNumbers(List<Seat> seats) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seats.size(); i++) {

            if (i > 0) {
                result.append(", ");
            }

            result.append(
                    seats.get(i).getSeatNumber()
            );
        }

        return result.toString();
    }

    public boolean cancelBooking(
            Booking booking,
            java.time.LocalDateTime currentTime) {

        if (booking == null) {
            return false;
        }

        boolean cancelled =
                booking.cancel(currentTime);

        if (cancelled) {
            System.out.println(
                    booking.getCustomer().getName()
                            + "'s booking cancelled."
            );

            System.out.println(
                    "Seats "
                            + getSeatNumbers(
                            booking.getSeats())
                            + " released."
            );
        } else {
            System.out.println(
                    "Booking cannot be cancelled."
            );
        }

        return cancelled;
    }
}