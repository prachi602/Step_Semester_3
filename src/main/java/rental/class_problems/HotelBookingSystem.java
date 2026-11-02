package rental.class_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingSystem {

    private List<Reservation> reservations;

    public HotelBookingSystem() {
        reservations = new ArrayList<>();
    }

    public boolean isRoomAvailable(
            Room room,
            LocalDate checkIn,
            LocalDate checkOut) {

        for (Reservation reservation : reservations) {

            if (reservation.getRoom() == room
                    && reservation.getStatus()
                    == Reservation.Status.ACTIVE) {

                boolean overlaps =
                        checkIn.isBefore(reservation.getCheckOut())
                                && checkOut.isAfter(
                                reservation.getCheckIn());

                if (overlaps) {
                    return false;
                }
            }
        }

        return true;
    }

    public Reservation createReservation(
            Customer customer,
            Room room,
            LocalDate checkIn,
            LocalDate checkOut,
            LocalDate cancellationDeadline) {

        if (!isRoomAvailable(room, checkIn, checkOut)) {
            System.out.println(
                    "Room " + room.getRoomNumber()
                            + " is unavailable for the selected dates."
            );
            return null;
        }

        Reservation reservation =
                new Reservation(
                        customer,
                        room,
                        checkIn,
                        checkOut,
                        cancellationDeadline
                );

        reservations.add(reservation);

        System.out.println(
                "Reservation created for Room "
                        + room.getRoomNumber()
        );

        System.out.println(
                "Total price: $"
                        + reservation.calculatePrice()
        );

        return reservation;
    }

    public boolean cancelReservation(
            Reservation reservation,
            LocalDate cancellationDate) {

        if (reservation == null) {
            return false;
        }

        boolean cancelled =
                reservation.cancel(cancellationDate);

        if (cancelled) {
            System.out.println(
                    "Reservation cancelled successfully."
            );
        } else {
            System.out.println(
                    "Reservation cannot be cancelled."
            );
        }

        return cancelled;
    }
}