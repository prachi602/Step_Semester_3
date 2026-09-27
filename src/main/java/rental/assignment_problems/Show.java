package rental.assignment_problems;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Show {

    private String showId;
    private String movieName;
    private LocalDateTime startTime;
    private Set<String> bookedSeats;

    public Show(
            String showId,
            String movieName,
            LocalDateTime startTime) {

        if (showId == null || showId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Show ID cannot be blank"
            );
        }

        if (movieName == null || movieName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Movie name cannot be blank"
            );
        }

        if (startTime == null) {
            throw new IllegalArgumentException(
                    "Start time cannot be null"
            );
        }

        this.showId = showId;
        this.movieName = movieName;
        this.startTime = startTime;
        this.bookedSeats = new HashSet<>();
    }

    public String getShowId() {
        return showId;
    }

    public String getMovieName() {
        return movieName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public boolean hasStarted(LocalDateTime currentTime) {
        return !currentTime.isBefore(startTime);
    }

    public boolean isSeatAvailable(Seat seat) {
        return seat != null
                && !bookedSeats.contains(seat.getSeatNumber());
    }

    public boolean reserveSeat(Seat seat) {
        if (!isSeatAvailable(seat)) {
            return false;
        }

        bookedSeats.add(seat.getSeatNumber());
        return true;
    }

    public void releaseSeat(Seat seat) {
        if (seat != null) {
            bookedSeats.remove(seat.getSeatNumber());
        }
    }
}