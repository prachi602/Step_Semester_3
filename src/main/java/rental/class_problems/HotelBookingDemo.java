package rental.class_problems;

import java.time.LocalDate;

public class HotelBookingDemo {

    public static void main(String[] args) {

        HotelBookingSystem system =
                new HotelBookingSystem();

        Customer customer1 =
                new Customer("C101", "Customer 1");

        Customer customer2 =
                new Customer("C102", "Customer 2");

        Room standardRoom =
                new StandardRoom("101", 100);

        Room deluxeRoom =
                new DeluxeRoom("201", 150);

        // First reservation: January 1 - January 5
        Reservation reservation1 =
                system.createReservation(
                        customer1,
                        standardRoom,
                        LocalDate.of(2027, 1, 1),
                        LocalDate.of(2027, 1, 5),
                        LocalDate.of(2026, 12, 30)
                );

        // Overlapping reservation: January 3 - January 7
        system.createReservation(
                customer2,
                standardRoom,
                LocalDate.of(2027, 1, 3),
                LocalDate.of(2027, 1, 7),
                LocalDate.of(2026, 12, 30)
        );

        // Cancel first reservation before deadline
        system.cancelReservation(
                reservation1,
                LocalDate.of(2026, 12, 29)
        );

        // Deluxe Room: February 10 - February 12
        system.createReservation(
                customer2,
                deluxeRoom,
                LocalDate.of(2027, 2, 10),
                LocalDate.of(2027, 2, 12),
                LocalDate.of(2027, 2, 5)
        );
    }
}