package rental.assignment_problems;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TicketBookingDemo {

    public static void main(String[] args) {

        TicketBookingSystem system =
                new TicketBookingSystem();

        Customer asha =
                new Customer("C101", "Asha");

        Customer ravi =
                new Customer("C102", "Ravi");

        Customer neha =
                new Customer("C103", "Neha");

        Show show =
                new Show(
                        "SHOW01",
                        "Campus Premiere",
                        LocalDateTime.of(
                                2027,
                                3,
                                20,
                                19,
                                0
                        )
                );

        Seat a1 =
                new RegularSeat("A1");

        Seat a2 =
                new RegularSeat("A2");

        Seat f5 =
                new PremiumSeat("F5");

        Seat r1 =
                new ReclinerSeat("R1");

        // Asha books A1, A2 and F5
        Booking ashaBooking =
                system.createBooking(
                        asha,
                        show,
                        Arrays.asList(a1, a2, f5)
                );

        // Ravi attempts to book already-booked A2
        system.createBooking(
                ravi,
                show,
                Arrays.asList(a2)
        );

        // Ravi books R1
        Booking raviBooking =
                system.createBooking(
                        ravi,
                        show,
                        Arrays.asList(r1)
                );

        // Asha cancels before the show starts
        system.cancelBooking(
                ashaBooking,
                LocalDateTime.of(
                        2027,
                        3,
                        20,
                        18,
                        0
                )
        );

        // Neha books the released A2
        system.createBooking(
                neha,
                show,
                Arrays.asList(a2)
        );
    }
}