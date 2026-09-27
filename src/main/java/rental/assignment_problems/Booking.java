package rental.assignment_problems;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    public enum Status {
        CONFIRMED,
        CANCELLED
    }

    private Customer customer;
    private Show show;
    private List<Seat> seats;
    private Status status;

    public Booking(
            Customer customer,
            Show show,
            List<Seat> seats) {

        if (customer == null) {
            throw new IllegalArgumentException(
                    "Customer cannot be null"
            );
        }

        if (show == null) {
            throw new IllegalArgumentException(
                    "Show cannot be null"
            );
        }

        if (seats == null || seats.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one seat is required"
            );
        }

        if (seats.size() > 6) {
            throw new IllegalArgumentException(
                    "Maximum 6 seats allowed per booking"
            );
        }

        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>(seats);
        this.status = Status.CONFIRMED;
    }

    public double calculateTotal() {
        double total = 0;

        for (Seat seat : seats) {
            total += seat.getPrice();
        }

        return total;
    }

    public boolean cancel(LocalDateTime currentTime) {

        if (status == Status.CANCELLED) {
            return false;
        }

        if (show.hasStarted(currentTime)) {
            return false;
        }

        for (Seat seat : seats) {
            show.releaseSeat(seat);
        }

        status = Status.CANCELLED;
        return true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    public Status getStatus() {
        return status;
    }
}