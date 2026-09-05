package oop.assignment_problems;

public class HallTicket {

    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        // Create one HallTicket object
        HallTicket priya =
                new HallTicket("Priya", 0);

        // Second variable points to the same object
        HallTicket copy = priya;

        // Change the object through the second reference
        copy.seatNumber = 45;

        System.out.println(
                "Priya's seatNumber (via first variable):"
        );
        System.out.println(priya.seatNumber);

        System.out.println(
                "copy == priya: " + (copy == priya)
        );

        // Create a separate object with identical values
        HallTicket separate =
                new HallTicket("Priya", 45);

        System.out.println(
                "separate == priya: " + (separate == priya)
        );
    }
}