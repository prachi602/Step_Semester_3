package rental.class_problems;

import java.time.LocalDate;

public class Reservation {

    public enum Status {
        ACTIVE,
        CANCELLED
    }

    private Customer customer;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private LocalDate cancellationDeadline;
    private Status status;

    public Reservation(
            Customer customer,
            Room room,
            LocalDate checkIn,
            LocalDate checkOut,
            LocalDate cancellationDeadline) {

        if (customer == null || room == null) {
            throw new IllegalArgumentException(
                    "Customer and room cannot be null"
            );
        }

        if (checkIn == null || checkOut == null) {
            throw new IllegalArgumentException(
                    "Dates cannot be null"
            );
        }

        if (!checkOut.isAfter(checkIn)) {
            throw new IllegalArgumentException(
                    "Check-out must be after check-in"
            );
        }

        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cancellationDeadline = cancellationDeadline;
        this.status = Status.ACTIVE;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Status getStatus() {
        return status;
    }

    public boolean cancel(LocalDate cancellationDate) {

        if (status == Status.CANCELLED) {
            return false;
        }

        if (cancellationDate == null) {
            return false;
        }

        if (cancellationDate.isAfter(cancellationDeadline)) {
            return false;
        }

        status = Status.CANCELLED;
        return true;
    }

    public long getNumberOfNights() {
        return java.time.temporal.ChronoUnit.DAYS.between(
                checkIn,
                checkOut
        );
    }

    public double calculatePrice() {
        return room.calculatePrice(
                (int) getNumberOfNights()
        );
    }
}
